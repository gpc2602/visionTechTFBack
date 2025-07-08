package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.NumeroEmergencia;
import upc.com.visiontech2.entities.Users;

import java.util.List;

@Repository
public interface NumeroEmergenciaRepository extends JpaRepository<NumeroEmergencia, Integer> {

    @Query("SELECT ne.distrito, COUNT(ne) FROM NumeroEmergencia ne GROUP BY ne.distrito")
    List<Object[]> countNumeroEmergenciaPorDistrito();

    @Query("SELECT ne FROM NumeroEmergencia ne WHERE ne.usuario.id = :userId ORDER BY ne.distrito ASC")
    List<NumeroEmergencia> findByUserId(@Param("userId") Long userId);

    @Query("SELECT ne FROM NumeroEmergencia ne WHERE (:tipoEmergencia IS NULL OR ne.tipoEmergencia = :tipoEmergencia) "
            +
            "AND (:distrito IS NULL OR ne.distrito = :distrito) " +
            "AND (:usuario IS NULL OR ne.usuario = :usuario)")
    List<NumeroEmergencia> findByTipoYDistritoAndUsuario(@Param("tipoEmergencia") String tipoEmergencia,
            @Param("distrito") String distrito,
            @Param("usuario") Users usuario);

}
