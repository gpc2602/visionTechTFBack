package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.TemaForo;

import java.time.LocalDate;
import java.util.List;

public interface ITemaForoService {
    
    public List<TemaForo> list();

    public void insert(TemaForo t);

    public TemaForo listId(int idTemaForo);

    public void update(TemaForo t);

    public void delete(int idTemaForo);

    public List<TemaForo> TemasDespuesDeFecha(LocalDate fecha);

    public List<TemaForo> TemasAntesDeFecha(LocalDate fecha);

    public List<TemaForo> TemasCerrados();

    public List<TemaForo> TemasPorUsuario(int idUsuario);
}
