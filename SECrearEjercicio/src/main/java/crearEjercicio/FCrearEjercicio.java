/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearEjercicio;

import dtos.EjercicioDTO;

/**
 *
 * @author alex_
 */
public class FCrearEjercicio implements ICrearEjercicio{

    private CCrearEjercicio control;

    public FCrearEjercicio() {
        this.control = new CCrearEjercicio();
    }
    
    @Override
    public EjercicioDTO crearEjercicio(EjercicioDTO ejercicio) {
        return control.crearEjercicio(ejercicio);
    }
    
}
