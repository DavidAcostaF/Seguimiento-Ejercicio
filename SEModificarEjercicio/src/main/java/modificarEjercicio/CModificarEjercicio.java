package modificarEjercicio;

import dtos.EjercicioDTO;
import negocio.EjercicioBO;
import negocio.IEjercicioBO;

/**
 *
 * @author alex_
 */
public class CModificarEjercicio {
    
    private IEjercicioBO ejercicioBO;

    protected CModificarEjercicio() {
        this.ejercicioBO = new EjercicioBO();
    }
    
    protected EjercicioDTO modificarEjercicio(EjercicioDTO ejercicio){
        return ejercicioBO.modificarEjercicio(ejercicio);
    }
    
}
