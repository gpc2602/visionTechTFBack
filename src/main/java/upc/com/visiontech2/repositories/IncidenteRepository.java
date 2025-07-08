package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Incidente;

import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
    
    @Query("Select i from Incidente i where i.tipo like %:tipo%")
    List<Incidente> buscarTipo(@Param("tipo") String tipo);
}
