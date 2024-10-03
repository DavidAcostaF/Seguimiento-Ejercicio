package dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa una instancia de un ejercicio dentro de una rutina de entrenamiento
 */
@Entity
@Table(name = "ejercicios_diarios")
public class EjercicioDiario implements Serializable{  // Cambiado de Ejercicio a EjercicioDiario
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;
    
    
    @Column(name = "completado", nullable = false)
    private boolean completado;
    
    @ManyToOne
    @JoinColumn(name = "rutina_id", nullable = false)  
    private Rutina rutina;  
    
    public EjercicioDiario() {
    }

    // Constructor, getters y setters

    public EjercicioDiario(Ejercicio ejercicio, boolean completado, Rutina rutina) {
        this.ejercicio = ejercicio;
        this.completado = completado;
        this.rutina = rutina;
    }
    
    public EjercicioDiario(Ejercicio ejercicio, boolean completado) {
        this.ejercicio = ejercicio;
        this.completado = completado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }


    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    
    
}
