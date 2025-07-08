package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Respuesta;

import java.time.LocalDate;
import java.util.List;

public interface IRespuestaService {
    
    public List<Respuesta> list();

    public void insert(Respuesta r);

    public Respuesta listId(int idRespuesta);

    public void update(Respuesta r);

    public void delete(int idRespuesta);

    public List<Respuesta> RespuestasDespuesDeFecha(LocalDate fecha);

    public List<Respuesta> RespuestasAntesDeFecha(LocalDate fecha);

    public List<Object[]> CantidadRespuestasPorTema();

    public List<Object[]> TemasPorCantidadDeRespuestas();

    List<Respuesta> RespuestasPorTema(int idTema);
}
