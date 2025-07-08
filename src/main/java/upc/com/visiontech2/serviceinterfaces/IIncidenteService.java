package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Incidente;

import java.util.List;

public interface IIncidenteService {
    
    public List<Incidente> list();

    public void insert(Incidente i);

    public Incidente listId(int idIncidente);

    public void update(Incidente i);

    public void deleteByRutaId(int idIncidente);

    List<Incidente> buscarPorTipo(String tipo);
}
