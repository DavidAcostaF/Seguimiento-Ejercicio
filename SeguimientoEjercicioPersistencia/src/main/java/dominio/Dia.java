package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  Clase que representa un día de la rutina de un plan de entrenamiento
 *  Mapeado con JPA para persistir en una base de datos.
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
@Entity
@Table(name = "dias")
public class Dia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogeneración del ID
    @Column(name = "id")
    private Long id;

    @ManyToOne // Si muchos "Día" están relacionados con una "Rutina"
    @JoinColumn(name = "rutina_id", nullable = false) // Especifica la clave foránea
    private Rutina rutina;

    // Constructor vacío requerido por JPA
    public Dia() {
    }

    /**
     * Constructor de la clase Dia
     * @param rutina
     */
    public Dia(Rutina rutina) {
        this.rutina = rutina;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
