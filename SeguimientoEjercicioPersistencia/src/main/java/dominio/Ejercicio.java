package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase que representa la definición de un ejercicio en un plan de entrenamiento.
 * Contiene la estructura básica del ejercicio (nombre, series, repeticiones, etc.).
 */
@Entity
@Table(name = "ejercicios")
public class Ejercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "duracion", nullable = false)
    private float duracion;

    // Constructor vacío requerido por JPA
    public Ejercicio() {
    }

    // Constructor con todos los atributos menos el id (cuando se crea un nuevo ejercicio)
    public Ejercicio(String nombre, String tipo, float duracion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    // Constructor con id (para actualizaciones o casos donde ya existe el ejercicio)
    public Ejercicio(Long id, String nombre, String tipo, float duracion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
