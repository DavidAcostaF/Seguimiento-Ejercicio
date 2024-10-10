/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obtenerRutinas;

import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author alex_
 */
public class FObtenerRutinas implements IObtenerRutinas{

    private CObtenerRutinas control;

    public FObtenerRutinas() {
        this.control = new CObtenerRutinas();
    }
    
    @Override
    public RutinaDTO obtenerRutina(UsuarioDTO usuario, int dia) {
        return control.obtenerRutina(usuario, dia);
    }

    @Override
    public List<RutinaDTO> obtenerRutinas(UsuarioDTO usuario) {
        return control.obtenerRutinas(usuario);
    }
    
}
