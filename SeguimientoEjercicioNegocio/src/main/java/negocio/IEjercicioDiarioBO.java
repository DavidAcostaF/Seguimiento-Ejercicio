package negocio;

import dtos.EjercicioDiarioDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author af_da
 */
public interface IEjercicioDiarioBO {
    void crearEjercicioDiario(EjercicioDiarioDTO ejercicioDiario);
    public boolean eliminarEjercicioDiario(Long id);
    public EjercicioDiarioDTO obtenerEjercicioDiario(EjercicioDiarioDTO ejercicioDiario);
    public EjercicioDiarioDTO actualizarEstado(EjercicioDiarioDTO ejercicioDiario);
}
