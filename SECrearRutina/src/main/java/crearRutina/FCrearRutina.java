/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearRutina;

import dtos.RutinaDTO;

/**
 *
 * @author alex_
 */
public class FCrearRutina implements ICrearRutina{

    private CCrearRutina control;

    public FCrearRutina() {
        this.control = new CCrearRutina();
    }
    
    @Override
    public void crearRutina(RutinaDTO rutina) {
        control.crearRutina(rutina);
    }
    
}
