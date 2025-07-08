package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Metrica;

import java.util.List;

public interface IMetricaService {

    public List<Metrica> list();

    public void insert(Metrica m);

    public Metrica listId(int idMetrica);

    public void update(Metrica m);

    public void delete(int idMetrica);

    List<Metrica> listByNombreRuta(String nombreRuta);

    int sumCaloriasByNombreRuta(String nombreRuta);
}
