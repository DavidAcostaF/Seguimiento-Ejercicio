/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearEjercicioDiario;

import dtos.EjercicioDiarioDTO;
import negocio.EjercicioDiarioBO;
import negocio.IEjercicioDiarioBO;

/**
 *
 * @author alex_
 */
public class CCrearEjercicioDiario {
    
    private IEjercicioDiarioBO edBO;

    protected CCrearEjercicioDiario() {
        this.edBO = new EjercicioDiarioBO();
    }
    
    protected void crearEjercicioDiario(EjercicioDiarioDTO ejercicio){
        edBO.crearEjercicioDiario(ejercicio);
    }
    
    
}
