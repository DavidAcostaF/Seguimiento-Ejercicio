package dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un plan de entrenamiento semanal
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
@Entity
@Table(name = "planes_entrenamiento_semanales") // Mapea la clase a una tabla llamada "planes_entrenamiento_semanales"
public class PlanEntrenamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente un ID único
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Dia
    @JoinColumn(name = "plan_entrenamiento_id") // Clave foránea en la tabla dias
    private final List<DiaRutina> diasSemana;

    @Column(name = "fecha_inicio") // Nombre de la columna en la tabla
    private final LocalDate fechaInicio;

    @Column(name = "fecha_fin") // Nombre de la columna en la tabla
    private final LocalDate fechaFin;

    // Constructor vacío requerido por JPA
    protected PlanEntrenamiento() {
        this.diasSemana = null;
        this.fechaInicio = null;
        this.fechaFin = null;
    }

    /**
     * Constructor de la clase PlanEntrenamiento con todos los atributos
     * @param diasSemana
     * @param fechaInicio
     * @param fechaFin
     */
    public PlanEntrenamiento(List<DiaRutina> diasSemana, LocalDate fechaInicio, LocalDate fechaFin) {
        if (diasSemana.size() != 7) {
            throw new IllegalArgumentException("Un plan semanal debe contener exactamente 7 días.");
        }
        this.diasSemana = diasSemana;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        // Validación de fechas
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
    }

    // Getters

    public Long getId() {
        return id;
    }

    public List<DiaRutina> getDiasSemana() {
        return diasSemana;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
