/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package presentacion;

import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 */
public class SeguimientoEjercicioPresentacion {
    public static UsuarioDTO USUARIO;
    
    public static void main(String[] args) {
        LoginUsuario loginoUsuarios = new LoginUsuario();
        loginoUsuarios.setVisible(true);
    }
}
