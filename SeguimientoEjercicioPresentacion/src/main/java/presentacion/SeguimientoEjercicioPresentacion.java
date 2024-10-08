/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package presentacion;

import dtos.UsuarioDTO;
import negocio.DiaBO;
import negocio.IDiaBO;

/**
 *
 * @author af_da
 */
public class SeguimientoEjercicioPresentacion {
    public static UsuarioDTO USUARIO;
    public static Observable OBSERVABLE;
    
    public static void main(String[] args) {
        
        OBSERVABLE = new Observable();
        IDiaBO diaBO = new DiaBO();
        diaBO.setDias();
        LoginUsuario loginoUsuarios = new LoginUsuario();
        loginoUsuarios.setVisible(true);
        
        
    }
}
