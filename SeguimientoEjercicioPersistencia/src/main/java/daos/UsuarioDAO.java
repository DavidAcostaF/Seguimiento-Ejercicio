/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.agenciafiscaldaos.Conexion;
import dominio.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author af_da
 */
public class UsuarioDAO implements IUsuarioDAO{
    private IConexion conexion;

    public UsuarioDAO() {
        this.conexion = new Conexion();
    }
    
    
    @Override
    public Usuario crear(Usuario usuario) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.refresh(usuario);
        entityManager.close();
        return usuario;
    }

    @Override
    public Usuario obtener(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
