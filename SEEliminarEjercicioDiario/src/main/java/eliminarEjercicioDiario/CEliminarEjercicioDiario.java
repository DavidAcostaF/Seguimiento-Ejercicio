/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eliminarEjercicioDiario;

import negocio.EjercicioDiarioBO;
import negocio.IEjercicioDiarioBO;

/**
 *
 * @author alex_
 */
public class CEliminarEjercicioDiario {
    
    private IEjercicioDiarioBO edBO;

    protected CEliminarEjercicioDiario() {
        this.edBO = new EjercicioDiarioBO();
    }
    
    protected boolean eliminarEjercicioDiario(Long id){
        return edBO.eliminarEjercicioDiario(id);
    }
    
}
