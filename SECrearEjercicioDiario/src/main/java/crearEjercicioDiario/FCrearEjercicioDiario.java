/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearEjercicioDiario;

import dtos.EjercicioDiarioDTO;

/**
 *
 * @author alex_
 */
public class FCrearEjercicioDiario implements ICrearEjercicioDiario{

    private CCrearEjercicioDiario control;

    public FCrearEjercicioDiario() {
        this.control = new CCrearEjercicioDiario();
    }
    
    @Override
    public void crearEjercicioDiario(EjercicioDiarioDTO ejercicio) {
        control.crearEjercicioDiario(ejercicio);
    }
    
}
