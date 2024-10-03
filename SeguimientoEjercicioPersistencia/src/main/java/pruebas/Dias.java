package pruebas;

import daos.DiaDAO;
import daos.IDiaDAO;

/**
 *
 * @author af_da
 */
public class Dias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una instancia de DiaDAO
        IDiaDAO diaDAO = new DiaDAO();

        // Llamar al método seedDias para insertar los días en la base de datos
        diaDAO.seedDias();
    }
    
}
