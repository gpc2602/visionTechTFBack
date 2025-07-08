package upc.com.visiontech2.dto;

import java.time.LocalDate;

public class ListaMetricaPorRutaDTO {

    private int idMetrica;
    private int numeroPasos;
    private int caloriasQuemadas;
    private int tiempoEfectivoMinutos;
    private LocalDate fecha;
    private RutaDTO ruta;

    public int getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(int idMetrica) {
        this.idMetrica = idMetrica;
    }

    public RutaDTO getRuta() {
        return ruta;
    }

    public void setRuta(RutaDTO ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public int getNumeroPasos() {
        return numeroPasos;
    }

    public void setNumeroPasos(int numeroPasos) {
        this.numeroPasos = numeroPasos;
    }

    public int getTiempoEfectivoMinutos() {
        return tiempoEfectivoMinutos;
    }

    public void setTiempoEfectivoMinutos(int tiempoEfectivoMinutos) {
        this.tiempoEfectivoMinutos = tiempoEfectivoMinutos;
    }
}
