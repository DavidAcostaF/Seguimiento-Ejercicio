/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.EjercicioDAO;
import daos.IEjercicioDAO;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dominio.Ejercicio;
import dominio.Usuario;

/**
 *
 * @author af_da
 */
public class PruebasEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        IEjercicioDAO ejercicioDAO = new EjercicioDAO();

        Usuario usuario = new Usuario("123", "123","123", 25, 70.5f, 1.75f);
        
        Usuario usuarioCreado = usuarioDAO.crear(usuario);

        Ejercicio ejercicio = new Ejercicio("123", "123", 12, usuarioCreado);
            
        ejercicioDAO.crear(ejercicio);
    }
    
}
