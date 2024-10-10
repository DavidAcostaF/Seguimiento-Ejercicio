/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarEjercicioDiario;

import dtos.EjercicioDiarioDTO;

/**
 *
 * @author alex_
 */
public class FModificarEjercicioDiario implements IModificarEjercicioDiario{

    private CModificarEjercicioDiario control;

    public FModificarEjercicioDiario() {
        this.control = new CModificarEjercicioDiario();
    }    
    
    @Override
    public EjercicioDiarioDTO actualizarEstadoEjercicio(EjercicioDiarioDTO ejercicio) {
        return control.actualizarEstadoEjercicio(ejercicio);
    }
    
}
