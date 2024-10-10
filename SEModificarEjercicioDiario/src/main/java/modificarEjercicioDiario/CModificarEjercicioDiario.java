/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarEjercicioDiario;

import dtos.EjercicioDiarioDTO;
import negocio.EjercicioDiarioBO;
import negocio.IEjercicioDiarioBO;

/**
 *
 * @author alex_
 */
public class CModificarEjercicioDiario {
    
    private IEjercicioDiarioBO edNegocio;

    protected CModificarEjercicioDiario() {
        this.edNegocio = new EjercicioDiarioBO();
    }
    
    protected EjercicioDiarioDTO actualizarEstadoEjercicio(EjercicioDiarioDTO ejercicio){
        return edNegocio.actualizarEstado(ejercicio);
    }
    
}
