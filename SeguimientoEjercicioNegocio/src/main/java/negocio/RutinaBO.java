/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.EjercicioConversor;
import conversores.RutinaConversor;
import conversores.UsuarioConversor;
import daos.EjercicioDAO;
import daos.IEjercicioDAO;
import daos.IRutinaDAO;
import daos.RutinaDAO;
import dominio.Usuario;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 */
public class RutinaBO implements IRutinaBO{
    private IRutinaDAO rutinaDAO;
//    private EjercicioConversor conversor;
    private RutinaConversor conversor;
    private UsuarioConversor conversorUsuario;
    public RutinaBO() {
        this.rutinaDAO = new RutinaDAO();
        conversor = new RutinaConversor();
        this.conversorUsuario = new UsuarioConversor();
    }
    @Override
    public void crearRutina(RutinaDTO rutina) {
        rutinaDAO.crearRutina(conversor.DTOAEntidad(rutina));
    }

    @Override
    public RutinaDTO obtenerRutina(UsuarioDTO usuario,int dia) {
        return conversor.EntidadADTO( rutinaDAO.obtenerRutinaUsuarioDia(conversorUsuario.DTOAEntidad(usuario), dia));
    }
    
}
