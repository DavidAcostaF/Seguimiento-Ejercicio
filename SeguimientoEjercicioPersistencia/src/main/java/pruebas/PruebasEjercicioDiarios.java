/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.EjercicioDiarioDAO;
import daos.IEjercicioDiarioDAO;
import dominio.Rutina;

/**
 *
 * @author af_da
 */
public class PruebasEjercicioDiarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IEjercicioDiarioDAO ejercicioDiarioDAO = new EjercicioDiarioDAO();
        Rutina rutina = new Rutina();
    }
    
}
