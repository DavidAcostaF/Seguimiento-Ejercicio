/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.UsuarioConversor;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 */
public class UsuariosBO implements IUsuarioBO{
    private IUsuarioDAO usuarioDAO;
    private UsuarioConversor conversor;
    public UsuariosBO() {
        this.usuarioDAO = new UsuarioDAO();
        conversor = new UsuarioConversor();
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) {
        return conversor.EntidadADTO(usuarioDAO.crear(conversor.DTOAEntidad(usuario)));
    }

    @Override
    public UsuarioDTO obtenerUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
