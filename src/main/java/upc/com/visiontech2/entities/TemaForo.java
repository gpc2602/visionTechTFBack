package upc.com.visiontech2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tema_foro")
public class TemaForo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTema;

    @Column(name = "tituloTema", nullable = false, length = 40)
    private String tituloTema;

    @Column(name = "comentario", nullable = false, length = 40)
    private String comentario;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "estadoCerrado", nullable = false)
    private boolean estadoCerrado;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public TemaForo() {
    }

    public TemaForo(int idTema, String tituloTema, String comentario, LocalDate fechaCreacion, boolean estadoCerrado,
            Users usuario) {
        this.idTema = idTema;
        this.tituloTema = tituloTema;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
        this.estadoCerrado = estadoCerrado;
        this.usuario = usuario;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTituloTema() {
        return tituloTema;
    }

    public void setTituloTema(String tituloTema) {
        this.tituloTema = tituloTema;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstadoCerrado() {
        return estadoCerrado;
    }

    public void setEstadoCerrado(boolean estadoCerrado) {
        this.estadoCerrado = estadoCerrado;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
