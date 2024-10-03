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
import dominio.Rutina;
import dominio.Usuario;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<RutinaDTO> obtenerRutinas(UsuarioDTO usuario) {
        List<Rutina> rutinasObtenidas = rutinaDAO.obtenerRutinas(conversorUsuario.DTOAEntidad(usuario));
        System.out.println(rutinasObtenidas);
        List<RutinaDTO> rutinasEncontradas = new ArrayList<>();
        if (rutinasObtenidas != null) {
            for (Rutina rObt : rutinasObtenidas) {
                rutinasEncontradas.add(conversor.EntidadADTO(rObt));
            }
        }
        return rutinasEncontradas;

    }

}
