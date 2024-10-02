package dtos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record UsuarioDTO(
    Long id,
    String nombre,
    String nomUsuario,
    String contrasenia,
    int edad,
    float peso,
    float estatura
//    PlanEntrenamiento planEntrenamiento
) implements Serializable {
    // Puedes agregar métodos adicionales aquí si es necesario
}
