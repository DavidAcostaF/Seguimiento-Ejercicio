/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import daos.EjercicioDiarioDAO;
import daos.IEjercicioDiarioDAO;

/**
 *
 * @author af_da
 */
public class EjercicioDiarioBO implements IEjercicioDiarioBO{
    private IEjercicioDiarioDAO ejercicioDiarioDAO;
//    private UsuarioConversor conversor;
    public EjercicioDiarioBO() {
        this.ejercicioDiarioDAO = new EjercicioDiarioDAO();
//        conversor = new UsuarioConversor();
    }
    @Override
    public void crearEjercicioDiario() {
        
    }
    
}
