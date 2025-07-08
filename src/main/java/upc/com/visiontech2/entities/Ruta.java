package upc.com.visiontech2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuta;

    @Column(name = "nombreRuta", nullable = false, length = 80)
    private String nombreRuta;

    @Column(name = "destino", nullable = false)
    private String destino; // Coordenadas: "lat,lng"

    @Column(name = "inicio", nullable = false)
    private String inicio; // Coordenadas: "lat,lng"

    @Column(name = "distanciaMetros", nullable = false)
    private int distanciaMetros;

    @Column(name = "favorito", nullable = false)
    private boolean favorito;

    @Column(name = "tiempoRuta", nullable = false)
    private int tiempoRuta;

    @Column(name = "longitud", nullable = false)
    private double longitud;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Users usuario;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Metrica> metricas = new ArrayList<>();

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<CondicionAtmosferica> condicionesAtmosfericas = new ArrayList<>();

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Incidente> incidentes = new ArrayList<>();

    public Ruta() {
    }

    public Ruta(int idRuta, String nombreRuta, String destino, String inicio, String fin, int distanciaMetros,
            int tiempoRuta, double longitud, double latitud, Users usuario) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.destino = destino;
        this.inicio = inicio;
        this.distanciaMetros = distanciaMetros;
        this.tiempoRuta = tiempoRuta;
        this.longitud = longitud;
        this.latitud = latitud;
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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
