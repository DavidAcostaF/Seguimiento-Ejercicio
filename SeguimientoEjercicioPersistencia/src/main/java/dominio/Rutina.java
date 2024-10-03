package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa una rutina de un plan de entrenamiento
 * @author David Acosta
 */
@Entity
@Table(name = "rutinas")  // Mapea la clase a una tabla llamada "rutinas"
public class Rutina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera automáticamente un ID único
    private Long id;

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EjercicioDiario> ejerciciosDiarios;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)  // Nueva relación
    private Usuario usuario;  // Nuevo atributo que referencia al usuario
    
    @ManyToOne()
    @JoinColumn(name = "dia_id", nullable = false)
    private Dia dia;
    
    // Constructor vacío requerido por JPA
    public Rutina() {
    }

    public Rutina(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rutina(Usuario usuario, Dia dia) {
        this.usuario = usuario;
        this.dia = dia;
    }

    /**
     * Constructor de la clase Rutina con todos los atributos.
     * @param ejercicios
     */
    public Rutina(List<EjercicioDiario> ejercicios) {
        this.ejerciciosDiarios = ejercicios;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
    public List<EjercicioDiario> getEjerciciosDiarios() {
        return ejerciciosDiarios;
    }

    public void setEjerciciosDiarios(List<EjercicioDiario> ejerciciosDiarios) {
        this.ejerciciosDiarios = ejerciciosDiarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
