package upc.com.visiontech2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "respuestas")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "respuesta", nullable = false, length = 50)
    private String respuesta;

    @Column(name = "fechaRespuesta", nullable = false)
    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "idTema")
    private TemaForo temaForo;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, String respuesta, LocalDate fechaRespuesta, TemaForo temaForo) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.temaForo = temaForo;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public TemaForo getTemaForo() {
        return temaForo;
    }

    public void setTemaForo(TemaForo temaForo) {
        this.temaForo = temaForo;
    }
}
