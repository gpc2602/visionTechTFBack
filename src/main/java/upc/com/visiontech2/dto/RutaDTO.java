package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Users;

public class RutaDTO {

    private int idRuta;
    private String nombreRuta;
    private String destino;
    private String inicio;
    private boolean favorito;
    private int distanciaMetros;
    private int tiempoRuta;
    private double longitud;
    private double latitud;
    private Users usuario;

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getDistanciaMetros() {
        return distanciaMetros;
    }

    public void setDistanciaMetros(int distanciaMetros) {
        this.distanciaMetros = distanciaMetros;
    }

    public int getTiempoRuta() {
        return tiempoRuta;
    }

    public void setTiempoRuta(int tiempoRuta) {
        this.tiempoRuta = tiempoRuta;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
