/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dominio.Usuario;

/**
 *
 * @author af_da
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Usuario usuario = new Usuario("David Acosta", "david_acosta","123", 25, 70.5f, 1.75f);
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.crear(usuario);
        
    }
    
}
