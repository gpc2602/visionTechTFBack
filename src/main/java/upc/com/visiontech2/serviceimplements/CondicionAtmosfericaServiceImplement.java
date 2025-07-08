package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.CondicionAtmosferica;
import upc.com.visiontech2.repositories.CondicionAtmosfericaRepository;
import upc.com.visiontech2.serviceinterfaces.ICondicionAtmosfericaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CondicionAtmosfericaServiceImplement implements ICondicionAtmosfericaService {

    @Autowired
    private CondicionAtmosfericaRepository cR;

    @Override
    public List<CondicionAtmosferica> list() {
        return cR.findAll();
    }

    @Override
    public void insert(CondicionAtmosferica ca) {
        cR.save(ca);
    }

    @Override
    public CondicionAtmosferica listId(int idCondicionAtmosferica) {
        return cR.findById(idCondicionAtmosferica).orElse(new CondicionAtmosferica());
    }

    @Override
    public void update(CondicionAtmosferica ca) {
        cR.save(ca);
    }

    @Override
    public void delete(int idCondicionAtmosferica) {
        cR.deleteById(idCondicionAtmosferica);
    }

    @Override
    public List<CondicionAtmosferica> findByNombreRutaAndFechaHoraBetween(String nombreRuta, LocalDateTime fechainicio,
            LocalDateTime fechafin) {
        return cR.findByNombreRutaAndFechaHoraBetween(nombreRuta, fechainicio, fechafin);
    }

    @Override
    public Optional<CondicionAtmosferica> findUltimaByNombreRuta(String nombreRuta) {
        return cR.findUltimaByNombreRuta(nombreRuta.trim().toLowerCase());
    }
}
