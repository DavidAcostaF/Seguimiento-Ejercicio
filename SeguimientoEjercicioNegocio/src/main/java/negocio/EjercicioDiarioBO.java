/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.EjercicioDiarioConversor;
import daos.EjercicioDiarioDAO;
import daos.IEjercicioDiarioDAO;
import dtos.EjercicioDiarioDTO;

/**
 *
 * @author af_da
 */
public class EjercicioDiarioBO implements IEjercicioDiarioBO{
    private IEjercicioDiarioDAO ejercicioDiarioDAO;
    private EjercicioDiarioConversor conversor;
    
    public EjercicioDiarioBO() {
        this.ejercicioDiarioDAO = new EjercicioDiarioDAO();
        conversor = new EjercicioDiarioConversor();
    }
    @Override
    public void crearEjercicioDiario(EjercicioDiarioDTO ejercicioDiario) {
        ejercicioDiarioDAO.crear(conversor.DTOAEntidad(ejercicioDiario));
    }
    
}
