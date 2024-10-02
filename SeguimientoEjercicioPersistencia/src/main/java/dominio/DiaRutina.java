package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dia_rutina")
public class DiaRutina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Almacena el nombre del enum como String en la base de datos
    @Column(name = "nombre_dia", nullable = false)
    private String nombreDia;

    @OneToMany(mappedBy = "dia_rutina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EjercicioRutina> ejerciciosRutina;

    public DiaRutina() {
    }

    public DiaRutina(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public List<EjercicioRutina> getEjerciciosRutina() {
        return ejerciciosRutina;
    }

    public void setEjerciciosRutina(List<EjercicioRutina> ejerciciosRutina) {
        this.ejerciciosRutina = ejerciciosRutina;
    }

    public void agregarEjercicioRutina(EjercicioRutina ejercicioRutina) {
        this.ejerciciosRutina.add(ejercicioRutina);
        ejercicioRutina.setDiaRutina(this); // Establece la relación bidireccional
    }

    public void eliminarEjercicioRutina(EjercicioRutina ejercicioRutina) {
        this.ejerciciosRutina.remove(ejercicioRutina);
        ejercicioRutina.setDiaRutina(null); // Elimina la relación bidireccional
    }
}
