/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.DiaDTO;
import java.util.List;

/**
 *
 * @author af_da
 */
public interface IDiaBO {
    List<DiaDTO> obtenerDias();
    int obtenerNumeroDia(String dia);
}
