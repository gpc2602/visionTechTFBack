package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Metrica;

import java.util.List;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica, Integer> {

    List<Metrica> findByOrderByIdMetricaAsc();

    // Buscar lista de metricas segun el nombre de la ruta
    @Query("SELECT m FROM Metrica " +
            "m JOIN m.ruta r " +
            "WHERE LOWER(r.nombreRuta) like (LOWER(:nombreRuta))")
    List<Metrica> findByNombreRutaContaining(@Param("nombreRuta") String nombreRuta);

    // cuenta total calorias por nombre ruta
    @Query("SELECT (SUM (m.caloriasQuemadas)) " +
            "FROM Metrica m " +
            "WHERE LOWER(TRIM(m.ruta.nombreRuta)) = LOWER((:nombreRuta))")
    int sumCaloriasByNombreRuta(@Param("nombreRuta") String nombreRuta);

}
