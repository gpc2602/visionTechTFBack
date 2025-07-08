package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.com.visiontech2.entities.Ruta;

import java.util.List;
import java.util.Optional;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    @Query("Select r from Ruta r where r.nombreRuta like %:nombre%")
    public List<Ruta> buscarNombre(@Param("nombre") String nombre);

    List<Ruta> findByFavoritoTrue();

    Ruta findTopByOrderByTiempoRutaAsc();

    Ruta findTopByOrderByDistanciaMetrosAsc();

    @Query("SELECT AVG(r.tiempoRuta) FROM Ruta r WHERE r.idRuta = :idRuta")
    Double obtenerPromedioTiempoPorRuta(int idRuta);

    Optional<Ruta> findByNombreRuta(String nombreRuta);
}
