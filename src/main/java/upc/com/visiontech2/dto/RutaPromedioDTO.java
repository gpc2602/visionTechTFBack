package upc.com.visiontech2.dto;

public class RutaPromedioDTO {
    
    private int idRuta;
    private double PromedioRecorrido;

    public RutaPromedioDTO(int idRuta, double promedioRecorrido) {
        this.idRuta = idRuta;
        PromedioRecorrido = promedioRecorrido;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public double getPromedioRecorrido() {
        return PromedioRecorrido;
    }

    public void setPromedioRecorrido(double promedioRecorrido) {
        PromedioRecorrido = promedioRecorrido;
    }
}
