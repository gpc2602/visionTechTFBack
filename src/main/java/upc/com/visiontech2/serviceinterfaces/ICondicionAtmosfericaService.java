package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.CondicionAtmosferica;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICondicionAtmosfericaService {

    public List<CondicionAtmosferica> list();

    public void insert(CondicionAtmosferica c);

    public CondicionAtmosferica listId(int idCondicionAtmosferica);

    public void update(CondicionAtmosferica c);

    public void delete(int idCondicionAtmosferica);

    List<CondicionAtmosferica> findByNombreRutaAndFechaHoraBetween(String nombreRuta, LocalDateTime fechainicio,
            LocalDateTime fechafin);

    Optional<CondicionAtmosferica> findUltimaByNombreRuta(String nombreRuta);
}
