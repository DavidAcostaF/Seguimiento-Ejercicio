/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominio.Ejercicio;
import java.util.List;


/**
 *
 * @author af_da
 */
public interface IEjercicioDAO {
    Ejercicio crear(Ejercicio ejercicio);
    List<Ejercicio> lista();
}