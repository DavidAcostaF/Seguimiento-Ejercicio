package dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase que representa a un usuario de la aplicación.
 *  @author David Acosta
 */
@Entity
@Table(name = "usuarios")  // Mapea la clase a una tabla llamada "usuarios"
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera automáticamente un ID único
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nom_usuario", unique = true, nullable = false)
    private String nomUsuario;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "peso")
    private float peso;

    @Column(name = "estatura")
    private float estatura;

    @OneToOne(cascade = CascadeType.ALL)  // Relación uno a uno con PlanEntrenamiento
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con todos los atributos.
     * @param nombre
     * @param nomUsuario
     * @param edad
     * @param peso
     * @param estatura
     * @param planEntrenamiento
     */
    public Usuario(String nombre, String nomUsuario, int edad, float peso, float estatura, PlanEntrenamiento planEntrenamiento) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.planEntrenamiento = planEntrenamiento;
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

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public PlanEntrenamiento getPlanEntrenamiento() {
        return planEntrenamiento;
    }

    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }
}
