package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Respuesta;
import upc.com.visiontech2.repositories.RespuestaRepository;
import upc.com.visiontech2.serviceinterfaces.IRespuestaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RespuestaServiceImplement implements IRespuestaService {
    
    @Autowired
    private RespuestaRepository rR;

    @Override
    public List<Respuesta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Respuesta a) {
        rR.save(a);
    }

    @Override
    public Respuesta listId(int idRespuesta) {
        return rR.findById(idRespuesta).orElse(new Respuesta());
    }

    @Override
    public void update(Respuesta a) {
        rR.save(a);
    }

    @Override
    public void delete(int idRespuesta) {
        rR.deleteById(idRespuesta);
    }

    @Override
    public List<Respuesta> RespuestasDespuesDeFecha(LocalDate fecha) {
        return rR.RespuestasDespuesDeFecha(fecha);
    }

    @Override
    public List<Respuesta> RespuestasAntesDeFecha(LocalDate fecha) {
        return rR.RespuestasAntesDeFecha(fecha);
    }

    @Override
    public List<Object[]> CantidadRespuestasPorTema() {
        return rR.CantidadRespuestasPorTema();
    }

    @Override
    public List<Object[]> TemasPorCantidadDeRespuestas() {
        return rR.TemasPorCantidadDeRespuestas();
    }

    @Override
    public List<Respuesta> RespuestasPorTema(int idTema) {
        return rR.RespuestasPorTema(idTema);
    }
}
