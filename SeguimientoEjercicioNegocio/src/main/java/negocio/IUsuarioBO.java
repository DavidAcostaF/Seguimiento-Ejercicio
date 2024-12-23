/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 */
public interface IUsuarioBO {
    UsuarioDTO crearUsuario(UsuarioDTO usuario);
    UsuarioDTO loginUsuario(UsuarioDTO usuario);
    boolean verificarUsuarioExistente(String nombreUusuario);
}
