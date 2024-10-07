package negocio;

import dtos.EjercicioDTO;
import java.util.List;

/**
 *
 * @author af_da
 */
public interface IEjercicioBO {
    EjercicioDTO crearEjercicio(EjercicioDTO ejercicioDTO);
    List<EjercicioDTO> listaEjercicios();
    EjercicioDTO modificarEjercicio(EjercicioDTO ejercicioDTO);
    boolean eliminarEjercicio(Long id);
}
