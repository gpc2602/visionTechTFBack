package upc.com.visiontech2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notificaciones")

public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @Column(name = "contenido", nullable = false, length = 40)
    private String contenido;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDate fechaHora;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String titulo, String contenido, LocalDate fechaHora, Ruta ruta) {
        this.idNotificacion = idNotificacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHora = fechaHora;
        this.ruta = ruta;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
