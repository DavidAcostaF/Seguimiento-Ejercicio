package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "peso")
    private float peso;

    @Column(name = "estatura")
    private float estatura;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rutina> rutinas;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    public Usuario(String nomUsuario, String contrasenia) {
        this.nomUsuario = nomUsuario;
        this.contrasenia = contrasenia;
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
    public Usuario(String nombre, String nomUsuario,String contrasenia, int edad, float peso, float estatura, List<Rutina> rutinas) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.edad = edad;
        this.contrasenia = contrasenia;
        this.peso = peso;
        this.estatura = estatura;
        this.rutinas = rutinas;
    }

    public Usuario(Long id, String nombre, String nomUsuario, String contrasenia, int edad, float peso, float estatura, List<Rutina> rutinas) {
        this.id = id;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.rutinas = rutinas;
    }

    public Usuario(String nombre, String nomUsuario,String contrasenia,  int edad, float peso, float estatura) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.contrasenia = contrasenia;
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

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    
    
}
