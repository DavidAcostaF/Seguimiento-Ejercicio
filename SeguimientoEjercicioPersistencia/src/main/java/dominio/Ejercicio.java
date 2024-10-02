package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Clase que representa la definición de un ejercicio en un plan de entrenamiento.
 * Contiene la estructura básica del ejercicio (nombre, series, repeticiones, etc.).
 */
@Entity
@Table(name = "ejercicios")
public class Ejercicio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "series", nullable = false)
    private int series;

    @Column(name = "repeticiones", nullable = false)
    private int repeticiones;

    // Constructor vacío requerido por JPA
    public Ejercicio() {
    }

    /**
     * Constructor con todos los atributos
     * @param nombre Nombre del ejercicio
     * @param descripcion Descripción del ejercicio
     * @param series Número de series del ejercicio
     * @param repeticiones Número de repeticiones por serie
     */
    public Ejercicio(String nombre, String descripcion, int series, int repeticiones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    public Ejercicio(Long id, String nombre, String descripcion, int series, int repeticiones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", series=" + series +
                ", repeticiones=" + repeticiones +
                '}';
    }
    
    
    
}
