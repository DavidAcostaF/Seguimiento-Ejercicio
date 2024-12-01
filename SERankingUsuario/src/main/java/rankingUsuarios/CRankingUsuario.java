package rankingUsuarios;

import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import negocio.IRutinaBO;
import negocio.IUsuarioBO;
import negocio.RutinaBO;
import negocio.UsuariosBO;

/**
 *
 * @author alex_
 */
public class CRankingUsuario {

    private IUsuarioBO usuarioBO;
    private IRutinaBO rutinaBO;

    protected CRankingUsuario() {
        this.usuarioBO = new UsuariosBO();
        this.rutinaBO = new RutinaBO();
    }

    protected Map<String, Object> obtenerRanking(UsuarioDTO usuario) {
        Map<String, Object> ranking = new HashMap<>();

        UsuarioDTO usuarioEncontrado = usuarioBO.loginUsuario(usuario);
        List<RutinaDTO> rutinas = rutinaBO.obtenerRutinas(usuarioEncontrado);

        int ejerciciosTotales = 0;
        int ejerciciosCompletados = 0;

        for (RutinaDTO rutina : rutinas) {
            for (EjercicioDiarioDTO ejercicio : rutina.ejerciciosDiarios()) {
                ejerciciosTotales++;
                if (ejercicio.completado()) {
                    ejerciciosCompletados++;
                }
            }
        }
        double porcentajeUsuario = ejerciciosTotales > 0 ? (ejerciciosCompletados * 100.0) / ejerciciosTotales : 0;

        // se añade al usuario
        ranking.put(usuarioEncontrado.nomUsuario(), new Object[]{
            ejerciciosTotales,
            ejerciciosCompletados,
            String.format("%.2f%%", porcentajeUsuario)
        });

        // se añaden usuarios para prueba
        String[] usuariosSimulados = {"ALopez", "jPerez", "cSanchez"};
        int[][] datosSimulados = {
            {20, 18},
            {15, 10},
            {25, 20}
        };

        for (int i = 0; i < usuariosSimulados.length; i++) {
            int total = datosSimulados[i][0];
            int completados = datosSimulados[i][1];
            double porcentaje = total > 0 ? (completados * 100.0) / total : 0;

            ranking.put(usuariosSimulados[i], new Object[]{
                total,
                completados,
                String.format("%.2f%%", porcentaje)
            });
        }

        // se ordena el ranking
        return ranking.entrySet().stream()
                .sorted((a, b) -> {
                    Object[] datosA = (Object[]) a.getValue();
                    Object[] datosB = (Object[]) b.getValue();

                    double porcentajeA = Double.parseDouble(datosA[2].toString().replace("%", ""));
                    double porcentajeB = Double.parseDouble(datosB[2].toString().replace("%", ""));

                    return Double.compare(porcentajeB, porcentajeA);
                })
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);
    }

}
