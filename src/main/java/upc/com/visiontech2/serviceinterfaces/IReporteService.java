package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.dto.ChartDataDTO;
import upc.com.visiontech2.dto.ChartJSCompleteDTO;
import upc.com.visiontech2.dto.ReporteGeneralDTO;
import upc.com.visiontech2.dto.ResumenTextualDTO;

import java.util.List;

public interface IReporteService {
    
    ReporteGeneralDTO obtenerReporteGeneral();
    
    ResumenTextualDTO obtenerResumenTextual();
    
    List<ChartDataDTO> obtenerActividadUsuariosPorMes();
    
    List<ChartDataDTO> obtenerIncidentesPorTipo();
    
    List<ChartDataDTO> obtenerRendimientoRutas();
    
    List<ChartDataDTO> obtenerCondicionesAtmosfericasPorMes();
    
    ChartJSCompleteDTO obtenerGraficoActividadMensual();
    
    ChartJSCompleteDTO obtenerGraficoIncidentes();
}
