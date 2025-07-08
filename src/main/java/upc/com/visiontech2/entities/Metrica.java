package upc.com.visiontech2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "metricas")
public class Metrica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetrica;

    @Column(name = "numeroPasos", nullable = false)
    private int numeroPasos;

    @Column(name = "caloriaQuemadas", nullable = false)
    private int caloriasQuemadas;

    @Column(name = "tiempoEfectivoMinutos", nullable = false)
    private int tiempoEfectivoMinutos;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    public Metrica() {
    }

    public Metrica(int idMetrica, int numeroPasos, int caloriasQuemadas, int tiempoEfectivoMinutos, LocalDate fecha,
            Ruta ruta) {
        this.idMetrica = idMetrica;
        this.numeroPasos = numeroPasos;
        this.caloriasQuemadas = caloriasQuemadas;
        this.tiempoEfectivoMinutos = tiempoEfectivoMinutos;
        this.fecha = fecha;
        this.ruta = ruta;
    }

    public int getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(int idMetrica) {
        this.idMetrica = idMetrica;
    }

    public int getNumeroPasos() {
        return numeroPasos;
    }

    public void setNumeroPasos(int numeroPasos) {
        this.numeroPasos = numeroPasos;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public int getTiempoEfectivoMinutos() {
        return tiempoEfectivoMinutos;
    }

    public void setTiempoEfectivoMinutos(int tiempoEfectivoMinutos) {
        this.tiempoEfectivoMinutos = tiempoEfectivoMinutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
