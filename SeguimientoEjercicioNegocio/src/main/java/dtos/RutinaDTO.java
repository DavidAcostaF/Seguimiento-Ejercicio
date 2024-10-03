package dtos;

import dominio.EjercicioDiario;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

/**
 *
 * @author af_da
 */
public record RutinaDTO(Long id, List<EjercicioDiarioDTO>ejerciciosDiarios,UsuarioDTO usuario,DiaDTO dia) {

}
