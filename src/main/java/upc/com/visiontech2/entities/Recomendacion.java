package upc.com.visiontech2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion")
    private int idRecomendacion;

    @Column(name = "comentario", length = 40)
    private String comentario;

    @Column(name = "puntuacion")
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "idRuta") // FK que apunta a la entidad Ruta
    private Ruta ruta;

    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String comentario, int puntuacion, Ruta ruta) {
        this.idRecomendacion = idRecomendacion;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.ruta = ruta;
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
