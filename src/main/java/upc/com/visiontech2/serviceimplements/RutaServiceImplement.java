package upc.com.visiontech2.serviceimplements;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.com.visiontech2.dto.RutaPromedioDTO;
import upc.com.visiontech2.entities.Ruta;
import upc.com.visiontech2.repositories.NotificacionRepository;
import upc.com.visiontech2.repositories.RutaRepository;
import upc.com.visiontech2.serviceinterfaces.IRutaService;
import java.util.List;

@Service
public class RutaServiceImplement implements IRutaService {
    
    @Autowired
    private RutaRepository rR;
    @Autowired
    private NotificacionRepository nR;

    @Override
    public List<Ruta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Ruta r) {
        rR.save(r);
    }

    @Override
    public Ruta listId(int idRuta) {
        return rR.findById(idRuta).orElse(new Ruta());
    }

    @Override
    public void update(Ruta r) {
        rR.save(r);
    }

    @Override
    public void marcarFavorita(int idRuta, boolean estado) {
        Ruta ruta = rR.findById(idRuta).orElse(null);
        if (ruta != null) {
            ruta.setFavorito(estado);
            rR.save(ruta);
        }

    }

    @Override
    @Transactional
    public void delete(int idRuta) {
        Ruta ruta = rR.findById(idRuta).orElse(null);
        if (ruta != null) {
            nR.deleteByRuta_IdRuta(idRuta);
            rR.deleteById(idRuta);
        }
    }

    @Override
    public List<Ruta> listarFavoritas() {
        return rR.findByFavoritoTrue();
    }

    @Override
    public Ruta obtenerRutaMasCortaPorTiempo() {
        return rR.findTopByOrderByTiempoRutaAsc();
    }

    @Override
    public Ruta obtenerRutaMasCortaPorDistancia() {
        return rR.findTopByOrderByDistanciaMetrosAsc();
    }

    @Override
    public RutaPromedioDTO obtenerPromedioTiempoRuta(int idRuta) {
        Double promedio = rR.obtenerPromedioTiempoPorRuta(idRuta);
        if (promedio == null)
            promedio = 0.0;
        return new RutaPromedioDTO(idRuta, promedio);
    }

    @Override
    public Ruta obtenerPorNombre(String nombreRuta) {
        return rR.findByNombreRuta(nombreRuta)
                .orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada con nombre: " + nombreRuta));
    }
}
