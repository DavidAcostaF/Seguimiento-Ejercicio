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
 * Clase que representa una instancia de un ejercicio dentro de una rutina de entrenamiento
 */
@Entity
@Table(name = "ejercicios_rutina")
public class EjercicioRutina implements Serializable{  // Cambiado de Ejercicio a EjercicioRutina
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;  // Referencia a la definición del ejercicio

    @Column(name = "completado")
    private boolean completado;
    @ManyToOne
    @JoinColumn(name = "dia_rutina_id", nullable = false)
    private DiaRutina diaRutina;
    public EjercicioRutina() {
    }

    // Constructor, getters y setters
    public EjercicioRutina(Ejercicio ejercicio, boolean completado) {
        this.ejercicio = ejercicio;
        this.completado = completado;
    }

    // Getters y setters
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public DiaRutina getDiaRutina() {
        return diaRutina;
    }

    public void setDiaRutina(DiaRutina diaRutina) {
        this.diaRutina = diaRutina;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
