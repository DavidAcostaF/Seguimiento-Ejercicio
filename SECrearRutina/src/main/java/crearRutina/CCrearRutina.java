/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearRutina;

import dtos.RutinaDTO;
import negocio.IRutinaBO;
import negocio.RutinaBO;

/**
 *
 * @author alex_
 */
public class CCrearRutina {
    
    private IRutinaBO rutinaBO;

    protected CCrearRutina() {
        this.rutinaBO = new RutinaBO();
    }
    
    protected void crearRutina(RutinaDTO rutina){
        rutinaBO.crearRutina(rutina);
    }
    
}
