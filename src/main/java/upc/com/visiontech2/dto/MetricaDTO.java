package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Ruta;

import java.time.LocalDate;

public class MetricaDTO {

    private int idMetrica;
    private int numeroPasos;
    private int caloriasQuemadas;
    private int tiempoEfectivoMinutos;
    private LocalDate fecha;
    private Ruta ruta;

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
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

}
