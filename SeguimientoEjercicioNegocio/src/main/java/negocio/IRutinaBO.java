/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominio.Usuario;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 */
public interface IRutinaBO {
    void crearRutina(RutinaDTO rutina);
    RutinaDTO obtenerRutina(UsuarioDTO usuario,int dia);
}
