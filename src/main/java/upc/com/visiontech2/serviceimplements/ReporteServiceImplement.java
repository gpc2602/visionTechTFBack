package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.dto.ChartDataDTO;
import upc.com.visiontech2.dto.ChartJSCompleteDTO;
import upc.com.visiontech2.dto.ChartJSDatasetDTO;
import upc.com.visiontech2.dto.ReporteGeneralDTO;
import upc.com.visiontech2.dto.ResumenTextualDTO;
import upc.com.visiontech2.repositories.ReporteRepository;
import upc.com.visiontech2.serviceinterfaces.IReporteService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteServiceImplement implements IReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    private final String[] COLORES_GRAFICO = {
            "#FF6384", "#36A2EB", "#FFCE56", "#4BC0C0", "#9966FF", 
            "#FF9F40", "#FF6384", "#C9CBCF", "#4BC0C0", "#FF6384"
    };

    private final String[] MESES = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    @Override
    public ReporteGeneralDTO obtenerReporteGeneral() {
        ResumenTextualDTO resumenTextual = obtenerResumenTextual();
        List<ChartDataDTO> actividadUsuarios = obtenerActividadUsuariosPorMes();
        List<ChartDataDTO> incidentesPorTipo = obtenerIncidentesPorTipo();

        return new ReporteGeneralDTO(resumenTextual, actividadUsuarios, incidentesPorTipo);
    }

    @Override
    public ResumenTextualDTO obtenerResumenTextual() {
        try {
            int totalUsuarios = reporteRepository.countTotalUsuarios().intValue();
            int totalRutas = reporteRepository.countTotalRutas().intValue();
            int totalIncidentes = reporteRepository.countTotalIncidentes().intValue();
            long totalPasos = reporteRepository.sumTotalPasos();
            long totalCalorias = reporteRepository.sumTotalCalorias();
            
            Double temperatura = reporteRepository.findPromedioTemperatura();
            double promedioTemperatura = temperatura != null ? temperatura : 0.0;
            
            String rutaMasUsada = reporteRepository.findRutasMasUsadas().isEmpty() ? 
                    "No disponible" : reporteRepository.findRutasMasUsadas().get(0);
            
            String tipoIncidenteMasFrecuente = reporteRepository.findTiposIncidenteMasFrecuentes().isEmpty() ? 
                    "No disponible" : reporteRepository.findTiposIncidenteMasFrecuentes().get(0);
            
            int totalMetricas = reporteRepository.countTotalMetricas().intValue();

            return new ResumenTextualDTO(
                    totalUsuarios, totalRutas, totalIncidentes, totalPasos,
                    totalCalorias, promedioTemperatura, rutaMasUsada,
                    tipoIncidenteMasFrecuente, totalMetricas
            );
        } catch (Exception e) {
            return new ResumenTextualDTO(0, 0, 0, 0, 0, 0.0, 
                    "No disponible", "No disponible", 0);
        }
    }

    @Override
    public List<ChartDataDTO> obtenerActividadUsuariosPorMes() {
        List<ChartDataDTO> resultado = new ArrayList<>();
        List<Object[]> datos = reporteRepository.findActividadUsuariosPorMes();

        for (int i = 0; i < datos.size() && i < 12; i++) {
            Object[] fila = datos.get(i);
            Integer anio = (Integer) fila[0];
            Integer mes = (Integer) fila[1];
            Long usuariosActivos = (Long) fila[2];

            String etiqueta = MESES[mes - 1] + " " + anio;
            
            ChartDataDTO chartData = new ChartDataDTO();
            chartData.setLabel(etiqueta);
            chartData.setValue(usuariosActivos.intValue());
            chartData.setBackgroundColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
            chartData.setBorderColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);

            resultado.add(chartData);
        }

        return resultado;
    }

    @Override
    public List<ChartDataDTO> obtenerIncidentesPorTipo() {
        List<ChartDataDTO> resultado = new ArrayList<>();
        List<Object[]> datos = reporteRepository.findIncidentesPorTipo();

        for (int i = 0; i < datos.size(); i++) {
            Object[] fila = datos.get(i);
            String tipo = (String) fila[0];
            Long cantidad = (Long) fila[1];

            ChartDataDTO chartData = new ChartDataDTO();
            chartData.setLabel(tipo);
            chartData.setValue(cantidad.intValue());
            chartData.setBackgroundColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
            chartData.setBorderColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);

            resultado.add(chartData);
        }

        return resultado;
    }

    @Override
    public List<ChartDataDTO> obtenerRendimientoRutas() {
        List<ChartDataDTO> resultado = new ArrayList<>();
        List<Object[]> datos = reporteRepository.findRendimientoRutas();

        for (int i = 0; i < datos.size() && i < 10; i++) {
            Object[] fila = datos.get(i);
            String nombreRuta = (String) fila[0];
            Long usos = (Long) fila[1];

            ChartDataDTO chartData = new ChartDataDTO();
            chartData.setLabel(nombreRuta);
            chartData.setValue(usos.intValue());
            chartData.setBackgroundColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
            chartData.setBorderColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);

            resultado.add(chartData);
        }

        return resultado;
    }

    @Override
    public List<ChartDataDTO> obtenerCondicionesAtmosfericasPorMes() {
        List<ChartDataDTO> resultado = new ArrayList<>();
        List<Object[]> datos = reporteRepository.findCondicionesAtmosfericasPorMes();
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < datos.size() && i < 12; i++) {
            Object[] fila = datos.get(i);
            Integer anio = (Integer) fila[0];
            Integer mes = (Integer) fila[1];
            Double promedioTemperatura = (Double) fila[2];

            String etiqueta = MESES[mes - 1] + " " + anio;
            
            ChartDataDTO chartData = new ChartDataDTO();
            chartData.setLabel(etiqueta);
            chartData.setValue(Double.parseDouble(df.format(promedioTemperatura)));
            chartData.setBackgroundColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
            chartData.setBorderColor(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);

            resultado.add(chartData);
        }

        return resultado;
    }

    @Override
    public ChartJSCompleteDTO obtenerGraficoActividadMensual() {
        List<String> labels = new ArrayList<>();
        List<Object> datosUsuarios = new ArrayList<>();
        List<Object> datosActividades = new ArrayList<>();
        
        List<Object[]> datos = reporteRepository.findActividadUsuariosPorMes();
        
        for (int i = 0; i < datos.size() && i < 12; i++) {
            Object[] fila = datos.get(i);
            Integer anio = (Integer) fila[0];
            Integer mes = (Integer) fila[1];
            Long usuariosActivos = (Long) fila[2];
            Long totalActividades = (Long) fila[3];
            
            String etiqueta = MESES[mes - 1] + " " + anio;
            labels.add(etiqueta);
            datosUsuarios.add(usuariosActivos);
            datosActividades.add(totalActividades);
        }
        
        List<ChartJSDatasetDTO> datasets = new ArrayList<>();
        
        ChartJSDatasetDTO datasetUsuarios = new ChartJSDatasetDTO();
        datasetUsuarios.setLabel("Usuarios Activos");
        datasetUsuarios.setData(datosUsuarios);
        datasetUsuarios.setBackgroundColor("rgba(54, 162, 235, 0.2)");
        datasetUsuarios.setBorderColor("rgba(54, 162, 235, 1)");
        datasetUsuarios.setBorderWidth(2);
        datasetUsuarios.setType("line");
        
        ChartJSDatasetDTO datasetActividades = new ChartJSDatasetDTO();
        datasetActividades.setLabel("Total Actividades");
        datasetActividades.setData(datosActividades);
        datasetActividades.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        datasetActividades.setBorderColor("rgba(255, 99, 132, 1)");
        datasetActividades.setBorderWidth(2);
        datasetActividades.setType("line");
        
        datasets.add(datasetUsuarios);
        datasets.add(datasetActividades);
        
        return new ChartJSCompleteDTO(labels, datasets, "line");
    }

    @Override
    public ChartJSCompleteDTO obtenerGraficoIncidentes() {
        List<String> labels = new ArrayList<>();
        List<Object> datos = new ArrayList<>();
        List<String> backgroundColors = new ArrayList<>();
        List<String> borderColors = new ArrayList<>();
        
        List<Object[]> datosIncidentes = reporteRepository.findIncidentesPorTipo();
        
        for (int i = 0; i < datosIncidentes.size(); i++) {
            Object[] fila = datosIncidentes.get(i);
            String tipo = (String) fila[0];
            Long cantidad = (Long) fila[1];
            
            labels.add(tipo);
            datos.add(cantidad);
            backgroundColors.add(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
            borderColors.add(COLORES_GRAFICO[i % COLORES_GRAFICO.length]);
        }
        
        List<ChartJSDatasetDTO> datasets = new ArrayList<>();
        
        ChartJSDatasetDTO dataset = new ChartJSDatasetDTO();
        dataset.setLabel("Incidentes por Tipo");
        dataset.setData(datos);
        dataset.setBackgroundColor(String.join(",", backgroundColors));
        dataset.setBorderColor(String.join(",", borderColors));
        dataset.setBorderWidth(1);
        
        datasets.add(dataset);
        
        return new ChartJSCompleteDTO(labels, datasets, "doughnut");
    }
}
