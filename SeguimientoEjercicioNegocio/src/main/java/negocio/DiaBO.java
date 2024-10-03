/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conversores.DiaConversor;
import daos.DiaDAO;
import daos.IDiaDAO;
import dominio.Dia;
import dtos.DiaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author af_da
 */
public class DiaBO implements IDiaBO {

    private IDiaDAO diaDAO;
    private DiaConversor conversor;

    public DiaBO() {
        this.diaDAO = new DiaDAO();
        conversor = new DiaConversor();
    }

    @Override
    public List<DiaDTO> obtenerDias() {
        List<Dia> listaDias = diaDAO.lista();
        List<DiaDTO> diasDTO = new ArrayList<>();
        for (Dia dia : listaDias) {
            diasDTO.add(conversor.EntidadADTO(dia));
        }
        return diasDTO;
    }

    @Override
    public void setDias() {
        diaDAO.seedDias();
    }

}
