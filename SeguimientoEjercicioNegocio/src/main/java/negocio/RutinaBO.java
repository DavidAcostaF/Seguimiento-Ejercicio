/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.EjercicioConversor;
import conversores.RutinaConversor;
import daos.EjercicioDAO;
import daos.IEjercicioDAO;
import daos.IRutinaDAO;
import daos.RutinaDAO;
import dtos.RutinaDTO;

/**
 *
 * @author af_da
 */
public class RutinaBO implements IRutinaBO{
    private IRutinaDAO rutinaDAO;
//    private EjercicioConversor conversor;
    private RutinaConversor conversor;
    public RutinaBO() {
        this.rutinaDAO = new RutinaDAO();
        conversor = new RutinaConversor();
    }
    @Override
    public void crearRutina(RutinaDTO rutina) {
        rutinaDAO.crearRutina(conversor.DTOAEntidad(rutina));
    }
    
}
