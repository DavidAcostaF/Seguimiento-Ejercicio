/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominio.Ejercicio;
import dominio.EjercicioDiario;
import java.util.List;


/**
 *
 * @author af_da
 */
public interface IEjercicioDAO {
    public Ejercicio crear(Ejercicio ejercicio);
    public Ejercicio obtenerEjercicioNombre(String nombre);
    public Ejercicio modificarEjercicio(Long idEjercicio, Ejercicio nuevoEjercicio);
    public boolean eliminarEjercicio(Long idEjercicio);
}
