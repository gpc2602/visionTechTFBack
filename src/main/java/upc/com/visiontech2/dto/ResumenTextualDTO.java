package upc.com.visiontech2.dto;

public class ResumenTextualDTO {
    private int totalUsuarios;
    private int totalRutas;
    private int totalIncidentes;
    private long totalPasos;
    private long totalCalorias;
    private double promedioTemperatura;
    private String rutaMasUsada;
    private String tipoIncidenteMasFrecuente;
    private int totalMetricas;

    public ResumenTextualDTO() {}

    public ResumenTextualDTO(int totalUsuarios, int totalRutas, int totalIncidentes, long totalPasos, 
                           long totalCalorias, double promedioTemperatura, String rutaMasUsada, 
                           String tipoIncidenteMasFrecuente, int totalMetricas) {
        this.totalUsuarios = totalUsuarios;
        this.totalRutas = totalRutas;
        this.totalIncidentes = totalIncidentes;
        this.totalPasos = totalPasos;
        this.totalCalorias = totalCalorias;
        this.promedioTemperatura = promedioTemperatura;
        this.rutaMasUsada = rutaMasUsada;
        this.tipoIncidenteMasFrecuente = tipoIncidenteMasFrecuente;
        this.totalMetricas = totalMetricas;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(int totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public int getTotalRutas() {
        return totalRutas;
    }

    public void setTotalRutas(int totalRutas) {
        this.totalRutas = totalRutas;
    }

    public int getTotalIncidentes() {
        return totalIncidentes;
    }

    public void setTotalIncidentes(int totalIncidentes) {
        this.totalIncidentes = totalIncidentes;
    }

    public long getTotalPasos() {
        return totalPasos;
    }

    public void setTotalPasos(long totalPasos) {
        this.totalPasos = totalPasos;
    }

    public long getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(long totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public double getPromedioTemperatura() {
        return promedioTemperatura;
    }

    public void setPromedioTemperatura(double promedioTemperatura) {
        this.promedioTemperatura = promedioTemperatura;
    }

    public String getRutaMasUsada() {
        return rutaMasUsada;
    }

    public void setRutaMasUsada(String rutaMasUsada) {
        this.rutaMasUsada = rutaMasUsada;
    }

    public String getTipoIncidenteMasFrecuente() {
        return tipoIncidenteMasFrecuente;
    }

    public void setTipoIncidenteMasFrecuente(String tipoIncidenteMasFrecuente) {
        this.tipoIncidenteMasFrecuente = tipoIncidenteMasFrecuente;
    }

    public int getTotalMetricas() {
        return totalMetricas;
    }

    public void setTotalMetricas(int totalMetricas) {
        this.totalMetricas = totalMetricas;
    }
}
