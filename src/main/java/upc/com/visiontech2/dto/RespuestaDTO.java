package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.TemaForo;

import java.time.LocalDate;

public class RespuestaDTO {

    private int idRespuesta;
    private String respuesta;
    private LocalDate fechaRespuesta;
    private TemaForo temaForo;

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
