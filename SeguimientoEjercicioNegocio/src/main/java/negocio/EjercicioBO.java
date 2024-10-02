/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.EjercicioConversor;
import conversores.IConversor;
import conversores.UsuarioConversor;
import daos.EjercicioDAO;
import daos.IEjercicioDAO;
import dominio.Ejercicio;
import dtos.EjercicioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author af_da
 */
public class EjercicioBO implements IEjercicioBO {

    private IEjercicioDAO ejercicioDAO;
    private EjercicioConversor conversor;

    public EjercicioBO() {
        this.ejercicioDAO = new EjercicioDAO();
        conversor = new EjercicioConversor();
    }

    @Override
    public EjercicioDTO crearEjercicio(EjercicioDTO ejercicioDTO) {
        return conversor.EntidadADTO(ejercicioDAO.crear(conversor.DTOAEntidad(ejercicioDTO)));
    }

    @Override
    public List<EjercicioDTO> listaEjercicios() {
        List<Ejercicio> listaEjercicios = ejercicioDAO.lista();
        List<EjercicioDTO> listaEjerciciosDTO = new ArrayList<>();
        for (Ejercicio ejercicio : listaEjercicios) {
            listaEjerciciosDTO.add(conversor.EntidadADTO(ejercicio));
        }
        return listaEjerciciosDTO;
    }

}
