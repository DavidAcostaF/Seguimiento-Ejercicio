/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eliminarEjercicio;

import dtos.EjercicioDTO;
import negocio.EjercicioBO;
import negocio.IEjercicioBO;

/**
 *
 * @author alex_
 */
public class CEliminarEjercicio {
    
    private IEjercicioBO ejercicioBO;

    protected CEliminarEjercicio() {
        this.ejercicioBO = new EjercicioBO();
    }
    
    protected boolean eliminarEjercicio(Long id){
        return ejercicioBO.eliminarEjercicio(id);
    }
    
}
