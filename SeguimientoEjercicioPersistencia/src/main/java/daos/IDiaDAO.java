/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominio.Dia;
import dominio.DiaSemana;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author af_da
 */
public interface IDiaDAO {
    void seedDias();
    Dia getOrCreate(EntityManager em, DiaSemana diaSemana);
    List<Dia> lista();
    boolean eliminar(Long id);
}
