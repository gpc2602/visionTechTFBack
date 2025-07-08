package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.dto.RecomendacionDTO;
import upc.com.visiontech2.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    
    public List<Recomendacion> list();

    public void insert(Recomendacion r);

    public Recomendacion listId(int idRecomendacion);

    public void update(Recomendacion r);

    public void delete(int idRecomendacion);

    public List<Recomendacion> buscarPorComentario(String comentario);

    void puntuarRuta(RecomendacionDTO dto);

    double obtenerPromedioPuntuacion(int idRecomendacion);
}
