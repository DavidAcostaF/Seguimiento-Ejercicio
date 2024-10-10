/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obtenerRutinas;

import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author alex_
 */
public interface IObtenerRutinas {
    
    public RutinaDTO obtenerRutina(UsuarioDTO usuario, int dia);
    public List<RutinaDTO> obtenerRutinas(UsuarioDTO usuario);
    
}
