/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import conversores.UsuarioConversor;
import dominio.Dia;
import dominio.Rutina;
import dtos.DiaDTO;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;
import negocio.DiaBO;
import negocio.RutinaBO;
import negocio.UsuariosBO;

/**
 *
 * @author af_da
 */
public class PruebasRutina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Paso 1: Crear un UsuarioDTO
        UsuarioDTO usuarioDTO = new UsuarioDTO(-1L,"Juan Perez", "Jperez", "Contra", 26, 75,1.78f);
        UsuarioConversor usuarioConversor = new UsuarioConversor();
        // Paso 2: Llamar al método login
        UsuariosBO usuarioBO = new UsuariosBO();
        UsuarioDTO usuarioConsultadoDTO = usuarioBO.loginUsuario(usuarioDTO);
        RutinaBO rutinaBO = new RutinaBO();
        if (usuarioConsultadoDTO!= null) {
            System.out.println("Inicio de sesión exitoso.");
            System.out.println(usuarioConsultadoDTO);
            // Paso 3: Obtener los días
            DiaBO diasBO = new DiaBO();
            List<DiaDTO> dias = diasBO.obtenerDias(); // Suponiendo que este método devuelve una lista de días

            // Imprimir los días (opcional)
            dias.forEach(dia -> {
                RutinaDTO rutinaDTO = new RutinaDTO(-1L,null,usuarioConsultadoDTO,dia);
                rutinaBO.crearRutina(rutinaDTO);
                }); 

            // Paso 4: Crear la rutina
//            Rutina nuevaRutina = new Rutina(usuarioDTO);

            // Puedes agregar ejercicios diarios a la rutina si es necesario

            System.out.println("Rutina creada con éxito.");
        } else {
            System.out.println("Error en el inicio de sesión.");
        }
    }
    
}
