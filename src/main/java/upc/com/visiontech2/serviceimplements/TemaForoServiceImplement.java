package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.TemaForo;
import upc.com.visiontech2.repositories.TemaForoRepository;
import upc.com.visiontech2.serviceinterfaces.ITemaForoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemaForoServiceImplement implements ITemaForoService {
    
    @Autowired
    private TemaForoRepository tR;

    @Override
    public List<TemaForo> list() {
        return tR.findAll();
    }

    @Override
    public void insert(TemaForo a) {
        tR.save(a);
    }

    @Override
    public TemaForo listId(int idTemaForo) {
        return tR.findById(idTemaForo).orElse(new TemaForo());
    }

    @Override
    public void update(TemaForo a) {
        tR.save(a);
    }

    @Override
    public void delete(int idTemaForo) {
        try {
            tR.deleteById(idTemaForo);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No se puede eliminar el tema porque tiene respuestas asociadas. Elimine primero las respuestas.");
        }
    }

    @Override
    public List<TemaForo> TemasDespuesDeFecha(LocalDate fecha) {
        return tR.TemasDespuesDeFecha(fecha);
    }

    @Override
    public List<TemaForo> TemasAntesDeFecha(LocalDate fecha) {
        return tR.TemasAntesDeFecha(fecha);
    }

    @Override
    public List<TemaForo> TemasCerrados() {
        return tR.TemasCerrados();
    }

    @Override
    public List<TemaForo> TemasPorUsuario(int idUsuario) {
        return tR.TemasPorUsuario(idUsuario);
    }
}
