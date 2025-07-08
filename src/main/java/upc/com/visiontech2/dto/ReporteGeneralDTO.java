package upc.com.visiontech2.dto;

import java.util.List;

public class ReporteGeneralDTO {
    private ResumenTextualDTO resumenTextual;
    private List<ChartDataDTO> actividadUsuariosPorMes;
    private List<ChartDataDTO> incidentesPorTipo;

    public ReporteGeneralDTO() {}

    public ReporteGeneralDTO(ResumenTextualDTO resumenTextual, List<ChartDataDTO> actividadUsuariosPorMes, List<ChartDataDTO> incidentesPorTipo) {
        this.resumenTextual = resumenTextual;
        this.actividadUsuariosPorMes = actividadUsuariosPorMes;
        this.incidentesPorTipo = incidentesPorTipo;
    }

    public ResumenTextualDTO getResumenTextual() {
        return resumenTextual;
    }

    public void setResumenTextual(ResumenTextualDTO resumenTextual) {
        this.resumenTextual = resumenTextual;
    }

    public List<ChartDataDTO> getActividadUsuariosPorMes() {
        return actividadUsuariosPorMes;
    }

    public void setActividadUsuariosPorMes(List<ChartDataDTO> actividadUsuariosPorMes) {
        this.actividadUsuariosPorMes = actividadUsuariosPorMes;
    }

    public List<ChartDataDTO> getIncidentesPorTipo() {
        return incidentesPorTipo;
    }

    public void setIncidentesPorTipo(List<ChartDataDTO> incidentesPorTipo) {
        this.incidentesPorTipo = incidentesPorTipo;
    }
}
