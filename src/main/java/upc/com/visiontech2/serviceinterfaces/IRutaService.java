package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.dto.RutaPromedioDTO;
import upc.com.visiontech2.entities.Ruta;

import java.util.List;

public interface IRutaService {
    
    public List<Ruta> list();

    public void insert(Ruta r);

    public Ruta listId(int idRuta);

    public void update(Ruta r);

    public void marcarFavorita(int idRuta, boolean estado);

    public void delete(int idRuta);

    List<Ruta> listarFavoritas();

    Ruta obtenerRutaMasCortaPorTiempo();

    Ruta obtenerRutaMasCortaPorDistancia();

    RutaPromedioDTO obtenerPromedioTiempoRuta(int idRuta);

    Ruta obtenerPorNombre(String nombreRuta);
}
