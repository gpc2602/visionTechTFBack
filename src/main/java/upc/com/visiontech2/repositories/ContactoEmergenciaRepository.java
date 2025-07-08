package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.ContactoEmergencia;

import java.util.List;

@Repository
public interface ContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia, Integer> {

    @Query("SELECT c FROM ContactoEmergencia c WHERE c.usuario.id = :idUsuario")
    List<ContactoEmergencia> obtenerContactosEmergenciaUsuario(@Param("idUsuario") Long idUsuario);
}
