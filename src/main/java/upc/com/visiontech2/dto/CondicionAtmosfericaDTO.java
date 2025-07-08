package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Ruta;

import java.time.LocalDateTime;

public class CondicionAtmosfericaDTO {

    private int idCondicionAtmosferica;
    private int humedad;
    private double temperatura;
    private int velocidadViento;
    private LocalDateTime fechaHora;

    private Ruta ruta;

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public CondicionAtmosfericaDTO() {
    }

    public CondicionAtmosfericaDTO(int idCondicionAtmosferica, double temperatura, int velocidadViento, int humedad,
            LocalDateTime fechaHora) {
        this.idCondicionAtmosferica = idCondicionAtmosferica;
        this.temperatura = temperatura;
        this.velocidadViento = velocidadViento;
        this.humedad = humedad;
        this.fechaHora = fechaHora;
    }

    public int getIdCondicionAtmosferica() {
        return idCondicionAtmosferica;
    }

    public void setIdCondicionAtmosferica(int idCondicionAtmosferica) {
        this.idCondicionAtmosferica = idCondicionAtmosferica;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(int velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}
