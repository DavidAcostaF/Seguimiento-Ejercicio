package daos;

import dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

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

        List<Usuario> resultados = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.nomUsuario = :nom_usuario AND u.contrasenia = :contrasenia", Usuario.class)
                .setParameter("nom_usuario", usuario.getNomUsuario())
                .setParameter("contrasenia", usuario.getContrasenia())
                .getResultList();

        if (resultados.isEmpty()) {
            return null; // No se encontró el usuario
        }

        return resultados.get(0); // Retorna el primer usuario encontrado
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
}
