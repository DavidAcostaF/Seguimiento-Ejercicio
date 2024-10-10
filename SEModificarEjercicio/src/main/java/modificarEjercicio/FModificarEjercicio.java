/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarEjercicio;

import dtos.EjercicioDTO;

/**
 *
 * @author alex_
 */
public class FModificarEjercicio implements IModificarEjercicio{

    private CModificarEjercicio control;

    public FModificarEjercicio() {
        this.control = new CModificarEjercicio();
    }
    
    @Override
    public EjercicioDTO modificarEjercicio(EjercicioDTO ejercicio) {
        return control.modificarEjercicio(ejercicio);
    }
    
}
