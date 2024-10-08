/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.EjercicioDiarioConversor;
import conversores.UsuarioConversor;
import daos.EjercicioDiarioDAO;
import daos.IEjercicioDiarioDAO;
import dominio.Dia;
import dominio.DiaSemana;
import dominio.EjercicioDiario;
import dtos.EjercicioDiarioDTO;

/**
 *
 * @author af_da
 */
public class EjercicioDiarioBO implements IEjercicioDiarioBO {
    
    private IEjercicioDiarioDAO ejercicioDiarioDAO;
    private EjercicioDiarioConversor conversor;
    private UsuarioConversor usuarioConversor;
    
    public EjercicioDiarioBO() {
        this.ejercicioDiarioDAO = new EjercicioDiarioDAO();
        conversor = new EjercicioDiarioConversor();
        usuarioConversor = new UsuarioConversor();
    }
    
    @Override
    public void crearEjercicioDiario(EjercicioDiarioDTO ejercicioDiario) {
        ejercicioDiarioDAO.crear(conversor.DTOAEntidad(ejercicioDiario));
    }
    
    @Override
    public boolean eliminarEjercicioDiario(Long id) {
        return ejercicioDiarioDAO.eliminarEjercicioDiario(id);
    }
    
    @Override
    public EjercicioDiarioDTO obtenerEjercicioDiario(EjercicioDiarioDTO ejercicioDiario) {
//        return conversor.EntidadADTO(ejercicioDiarioDAO.obtener(conversor.DTOAEntidad(ejercicioDiario)));
        return null;
    }
    
    @Override
    public EjercicioDiarioDTO actualizarEstado(EjercicioDiarioDTO ejercicioDiario) {
        EjercicioDiario ejercicioConvertido = conversor.DTOAEntidad(ejercicioDiario);
        ejercicioConvertido.getRutina().setDia(new Dia(DiaSemana.valueOf(ejercicioDiario.rutina().dia().nombre())));
        ejercicioConvertido.getRutina().setUsuario(usuarioConversor.DTOAEntidad(ejercicioDiario.rutina().usuario()));
        EjercicioDiario ejercicio = ejercicioDiarioDAO.obtener(ejercicioConvertido,ejercicioDiario.rutina().dia().toString());
        ejercicio.getRutina().setDia(new Dia(DiaSemana.valueOf(ejercicioDiario.rutina().dia().nombre())));
        ejercicio.setCompletado(!ejercicio.isCompletado());
        return conversor.EntidadADTO(ejercicioDiarioDAO.actualizar(ejercicio));
    }
    
}
