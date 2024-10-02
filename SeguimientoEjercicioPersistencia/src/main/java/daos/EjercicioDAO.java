/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.agenciafiscaldaos.Conexion;
import dominio.Ejercicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author af_da
 */
public class EjercicioDAO implements IEjercicioDAO{
    private IConexion conexion;

    public EjercicioDAO() {
        this.conexion = new Conexion();
    }
    @Override
    public Ejercicio crear(Ejercicio ejercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(ejercicio);
        entityManager.getTransaction().commit();
        entityManager.refresh(ejercicio);
        entityManager.close();
        return ejercicio;
    }

    @Override
    public List<Ejercicio> lista() {
        EntityManager entityManager = conexion.obtenerConexion();
        try {
            TypedQuery<Ejercicio> query = entityManager.createQuery("SELECT e FROM ejercicios e", Ejercicio.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // Devuelve una lista vacía en caso de error
        }
    }
    
}
