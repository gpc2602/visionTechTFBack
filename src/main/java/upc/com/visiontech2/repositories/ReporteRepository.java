package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Metrica;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Metrica, Integer> {

    @Query("SELECT " +
           "EXTRACT(YEAR FROM m.fecha) as anio, " +
           "EXTRACT(MONTH FROM m.fecha) as mes, " +
           "COUNT(DISTINCT r.usuario.idUsuario) as usuariosActivos, " +
           "COUNT(m.idMetrica) as totalActividades, " +
           "SUM(m.caloriasQuemadas) as totalCalorias " +
           "FROM Metrica m " +
           "JOIN m.ruta r " +
           "GROUP BY EXTRACT(YEAR FROM m.fecha), EXTRACT(MONTH FROM m.fecha) " +
           "ORDER BY anio DESC, mes DESC")
    List<Object[]> findActividadUsuariosPorMes();

    @Query("SELECT i.tipo, COUNT(i.idIncidente) as cantidad " +
           "FROM Incidente i " +
           "GROUP BY i.tipo " +
           "ORDER BY cantidad DESC")
    List<Object[]> findIncidentesPorTipo();

    @Query("SELECT COUNT(u.idUsuario) FROM Users u")
    Long countTotalUsuarios();

    @Query("SELECT COUNT(r.idRuta) FROM Ruta r")
    Long countTotalRutas();

    @Query("SELECT COUNT(i.idIncidente) FROM Incidente i")
    Long countTotalIncidentes();

    @Query("SELECT COALESCE(SUM(m.numeroPasos), 0) FROM Metrica m")
    Long sumTotalPasos();

    @Query("SELECT COALESCE(SUM(m.caloriasQuemadas), 0) FROM Metrica m")
    Long sumTotalCalorias();

    @Query("SELECT AVG(ca.temperatura) FROM CondicionAtmosferica ca")
    Double findPromedioTemperatura();

    @Query("SELECT r.nombreRuta " +
           "FROM Metrica m " +
           "JOIN m.ruta r " +
           "GROUP BY r.nombreRuta " +
           "ORDER BY COUNT(m.idMetrica) DESC")
    List<String> findRutasMasUsadas();

    @Query("SELECT i.tipo " +
           "FROM Incidente i " +
           "GROUP BY i.tipo " +
           "ORDER BY COUNT(i.idIncidente) DESC")
    List<String> findTiposIncidenteMasFrecuentes();

    @Query("SELECT COUNT(m.idMetrica) FROM Metrica m")
    Long countTotalMetricas();

    @Query("SELECT " +
           "r.nombreRuta, " +
           "COUNT(m.idMetrica) as usos, " +
           "AVG(m.caloriasQuemadas) as promedioCalorias, " +
           "AVG(m.numeroPasos) as promedioPasos, " +
           "AVG(m.tiempoEfectivoMinutos) as promedioTiempo " +
           "FROM Metrica m " +
           "JOIN m.ruta r " +
           "GROUP BY r.nombreRuta, r.idRuta " +
           "ORDER BY usos DESC")
    List<Object[]> findRendimientoRutas();

    @Query("SELECT " +
           "EXTRACT(YEAR FROM ca.fechaHora) as anio, " +
           "EXTRACT(MONTH FROM ca.fechaHora) as mes, " +
           "AVG(ca.temperatura) as promedioTemperatura, " +
           "AVG(ca.humedad) as promedioHumedad, " +
           "AVG(ca.velocidadViento) as promedioViento " +
           "FROM CondicionAtmosferica ca " +
           "GROUP BY EXTRACT(YEAR FROM ca.fechaHora), EXTRACT(MONTH FROM ca.fechaHora) " +
           "ORDER BY anio DESC, mes DESC")
    List<Object[]> findCondicionesAtmosfericasPorMes();
}
