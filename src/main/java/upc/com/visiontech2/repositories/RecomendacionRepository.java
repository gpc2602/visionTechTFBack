package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Recomendacion;

import java.util.List;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
    
    @Query("Select r from Recomendacion r where r.comentario like %:comentario%")
    public List<Recomendacion> buscarComentario(@Param("comentario") String comentario);

    @Query("SELECT AVG(r.puntuacion) FROM Recomendacion r WHERE r.ruta.idRuta = :idRuta")
    Double obtenerPromedioPuntuacion(@Param("idRecomendacion") int idRecomendacion);
}
