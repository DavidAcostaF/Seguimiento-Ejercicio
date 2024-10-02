package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa una rutina de un plan de entrenamiento
 *  @author David Acosta
 */
@Entity
@Table(name = "rutinas")  // Mapea la clase a una tabla llamada "rutinas"
public class Rutina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera automáticamente un ID único
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // Relación uno a muchos con Ejercicio
    @JoinColumn(name = "rutina_id")  // Define la clave foránea en la tabla ejercicios
    private List<Ejercicio> ejercicios;

    // Constructor vacío requerido por JPA
    public Rutina() {
    }

    /**
     * Constructor de la clase Rutina con todos los atributos.
     * @param ejercicios
     */
    public Rutina(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
