package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.ContactoEmergencia;
import upc.com.visiontech2.repositories.ContactoEmergenciaRepository;
import upc.com.visiontech2.serviceinterfaces.IContactoEmergenciaService;

import java.util.List;

@Service
public class ContactoEmergenciaServiceImplement implements IContactoEmergenciaService {

    @Autowired
    private ContactoEmergenciaRepository cR;

    @Override
    public List<ContactoEmergencia> list() {
        return cR.findAll();
    }

    @Override
    public void insert(ContactoEmergencia contactoEmergencia) {
        cR.save(contactoEmergencia);
    }

    @Override
    public ContactoEmergencia listId(int idContacto) {
        return cR.findById(idContacto).orElse(null);
    }

    @Override
    public void update(ContactoEmergencia contactoEmergencia) {
        cR.save(contactoEmergencia);
    }

    @Override
    public void delete(int idContacto) {
        cR.deleteById(idContacto);
    }

    @Override
    public List<ContactoEmergencia> obtenerContactosEmergenciaUsuario(Long idUsuario) {
        return cR.obtenerContactosEmergenciaUsuario(idUsuario);
    }
}
