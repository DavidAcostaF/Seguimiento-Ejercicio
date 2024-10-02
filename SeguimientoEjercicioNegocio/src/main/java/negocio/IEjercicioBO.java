/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.EjercicioDTO;
import java.util.List;

/**
 *
 * @author af_da
 */
public interface IEjercicioBO {
    void crearEjercicio(EjercicioDTO ejercicioDTO);
    List<EjercicioDTO> listaEjercicios();
}
