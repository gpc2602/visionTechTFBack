package upc.com.visiontech2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "condiciones_atmosfericas")
public class CondicionAtmosferica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCondicionAtmosferica;

    @Column(name = "humedad", nullable = false)
    private int humedad;

    @Column(name = "temperatura", nullable = false)
    private double temperatura;

    @Column(name = "velocidadViento", nullable = false)
    private int velocidadViento;

    @Column(name = "fechaHora", nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    public CondicionAtmosferica() {
    }

    public CondicionAtmosferica(int idCondicionAtmosferica, int humedad, double temperatura, int velocidadViento,
            LocalDateTime fechaHora, Ruta ruta) {
        this.idCondicionAtmosferica = idCondicionAtmosferica;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.velocidadViento = velocidadViento;
        this.fechaHora = fechaHora;
        this.ruta = ruta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
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

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(int velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}