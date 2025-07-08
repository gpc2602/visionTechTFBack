package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.CondicionAtmosferica;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CondicionAtmosfericaRepository extends JpaRepository<CondicionAtmosferica, Integer> {

    // recibe ruta fechaInicio fechaFin, devuelve lista conciones atmosfericas
    @Query("SELECT ca FROM CondicionAtmosferica ca " +
            "WHERE LOWER(ca.ruta.nombreRuta) = LOWER(:nombreRuta) " +
            "AND ca.fechaHora BETWEEN :fechaInicio AND :fechaFin")
    List<CondicionAtmosferica> findByNombreRutaAndFechaHoraBetween(
            @Param("nombreRuta") String nombreRuta,
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin);

    // muestra ultimo regIstro de CA segun nombre de ruta
    @Query("SELECT c FROM CondicionAtmosferica c WHERE LOWER(c.ruta.nombreRuta) = LOWER(:nombreRuta) " +
            "ORDER BY c.fechaHora DESC LIMIT 1")
    Optional<CondicionAtmosferica> findUltimaByNombreRuta(@Param("nombreRuta") String nombreRuta);

}