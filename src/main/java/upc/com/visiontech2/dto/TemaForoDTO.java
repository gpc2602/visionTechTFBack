package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Users;

import java.time.LocalDate;

public class TemaForoDTO {
    
    private int idTema;
    private String tituloTema;
    private String comentario;
    private LocalDate fechaCreacion;
    private boolean estadoCerrado;
    private Users usuario;

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
