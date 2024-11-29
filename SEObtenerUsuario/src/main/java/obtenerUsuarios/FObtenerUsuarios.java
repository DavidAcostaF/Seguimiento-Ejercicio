/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obtenerUsuarios;

import dtos.UsuarioDTO;

/**
 *
 * @author alex_
 */
public class FObtenerUsuarios implements IObtenerUsuarios{

    private CObtenerUsuarios control;

    public FObtenerUsuarios() {
        this.control = new CObtenerUsuarios();
    }
    
    @Override
    public UsuarioDTO obtenerUsuario(UsuarioDTO usuario) {
        return control.obtenerUsuario(usuario);
    }

    @Override
    public boolean verificarUsuario(String nombreUsuario) {
        return control.verificarUsuarioExistente(nombreUsuario);
    }
    
}
