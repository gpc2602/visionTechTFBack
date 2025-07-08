package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.NumeroEmergencia;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.repositories.NumeroEmergenciaRepository;
import upc.com.visiontech2.serviceinterfaces.INumeroEmergenciaService;

import java.util.List;

@Service
public class NumeroEmergenciaServiceImplement implements INumeroEmergenciaService {
    
    @Autowired
    private NumeroEmergenciaRepository nR;

    @Override
    public List<NumeroEmergencia> list() {
        return nR.findAll();
    }

    @Override
    public void insert(NumeroEmergencia n) {
        nR.save(n);
    }

    @Override
    public NumeroEmergencia listId(int idNumeroEmergencia) {
        return nR.findById(idNumeroEmergencia).orElse(new NumeroEmergencia());
    }

    @Override
    public void update(NumeroEmergencia n) {
        nR.save(n);
    }

    @Override
    public void delete(int idNumeroEmergencia) {
        nR.deleteById(idNumeroEmergencia);
    }

    @Override
    public List<Object[]> countNumeroEmergenciaPorDistrito() {
        return nR.countNumeroEmergenciaPorDistrito();
    }

    @Override
    public List<NumeroEmergencia> obtenerEmergenciasPorTipoYDistrito(String tipoEmergencia, String distrito,
            Users usuario) {
        return nR.findByTipoYDistritoAndUsuario(tipoEmergencia, distrito, usuario);
    }

    @Override
    public List<NumeroEmergencia> findByUserId(Long userId) {
        return nR.findByUserId(userId);
    }
}
