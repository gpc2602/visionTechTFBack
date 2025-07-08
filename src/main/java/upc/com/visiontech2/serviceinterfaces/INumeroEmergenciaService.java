package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.NumeroEmergencia;
import upc.com.visiontech2.entities.Users;

import java.util.List;

public interface INumeroEmergenciaService {

    public List<NumeroEmergencia> list();

    public void insert(NumeroEmergencia n);

    public NumeroEmergencia listId(int idNumeroEmergencia);

    public void update(NumeroEmergencia n);

    public void delete(int idNumeroEmergencia);

    public List<Object[]> countNumeroEmergenciaPorDistrito();

    public List<NumeroEmergencia> obtenerEmergenciasPorTipoYDistrito(String tipoEmergencia, String distrito,
            Users usuario);

    public List<NumeroEmergencia> findByUserId(Long userId);
}
