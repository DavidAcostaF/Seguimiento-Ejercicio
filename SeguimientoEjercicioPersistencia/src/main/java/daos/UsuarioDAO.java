package daos;

import dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author af_da
 */
public class UsuarioDAO implements IUsuarioDAO {

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
        EntityManager entityManager = conexion.obtenerConexion();

        try {
            return entityManager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nomUsuario = :nom_usuario AND u.contrasenia = :contrasenia", Usuario.class)
                    .setParameter("nom_usuario", usuario.getNomUsuario())
                    .setParameter("contrasenia", usuario.getContrasenia())
                    .getSingleResult();
            
        } catch (NoResultException e) {
            return null; // Retorna null si no se encontró ningún resultado
        }
    }

    @Override
    public void borrar(Usuario usuario) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();

        Usuario usuarioAEliminar = entityManager.find(Usuario.class, usuario.getId());
        if (usuarioAEliminar != null) {
            entityManager.remove(usuarioAEliminar);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Usuario obtenerNombre(String nombreUsuario) {
        EntityManager entityManager = conexion.obtenerConexion();

        try {
            return entityManager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nomUsuario = :nom_usuario", Usuario.class)
                    .setParameter("nom_usuario", nombreUsuario)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null si no se encontró ningún resultado
        }
    }
}
