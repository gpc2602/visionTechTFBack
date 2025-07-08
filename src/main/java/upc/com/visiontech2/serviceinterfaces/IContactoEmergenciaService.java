package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.ContactoEmergencia;

import java.util.List;

public interface IContactoEmergenciaService {
    
    List<ContactoEmergencia> list();

    void insert(ContactoEmergencia c);

    ContactoEmergencia listId(int idContacto);

    void update(ContactoEmergencia c);

    void delete(int idContacto);

    List<ContactoEmergencia> obtenerContactosEmergenciaUsuario(Long idUsuario);
}
