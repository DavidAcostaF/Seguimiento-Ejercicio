package crearEjercicio;

import dtos.EjercicioDTO;
import negocio.EjercicioBO;
import negocio.IEjercicioBO;

/**
 *
 * @author alex_
 */
public class CCrearEjercicio {
 
    private IEjercicioBO ejercicioBO;

    protected CCrearEjercicio() {
        this.ejercicioBO = new EjercicioBO();
    }
    
    protected EjercicioDTO crearEjercicio(EjercicioDTO ejercicio){
        return ejercicioBO.crearEjercicio(ejercicio);
    }
    
}
