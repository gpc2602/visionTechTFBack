package upc.com.visiontech2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "incidentes")
public class Incidente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidente;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "gravedad", nullable = false, length = 45)
    private String gravedad;

    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    public Incidente() {
    }

    public Incidente(int idIncidente, String tipo, String gravedad, String descripcion, Ruta ruta) {
        this.idIncidente = idIncidente;
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
