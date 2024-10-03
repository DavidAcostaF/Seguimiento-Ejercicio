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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int obtenerNumeroDia(String dia) {
        // Crear el mapa
        Map<String, Integer> diasSemana = new HashMap<>();

        // Llenar el mapa con los días de la semana
        diasSemana.put("Lunes", 1);
        diasSemana.put("Martes", 2);
        diasSemana.put("Miércoles", 3);
        diasSemana.put("Jueves", 4);
        diasSemana.put("Viernes", 5);
        diasSemana.put("Sábado", 6);
        diasSemana.put("Domingo", 7);

        // Obtener el valor del día, o devolver -1 si no existe
        return diasSemana.getOrDefault(dia, -1);
    }

}
