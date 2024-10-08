package daos;

import dominio.EjercicioDiario;

/**
 *
 * @author alex_
 */
public interface IEjercicioDiarioDAO {
    
    public EjercicioDiario crear(EjercicioDiario ejercicio);
    public boolean eliminarEjercicioDiario(Long idEjercicio);
    public EjercicioDiario obtener(EjercicioDiario ejercicio,String nombreDia);
    public EjercicioDiario actualizar(EjercicioDiario ejercicio);
}
