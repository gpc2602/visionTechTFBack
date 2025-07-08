package upc.com.visiontech2.dto;

import java.util.List;

public class ChartJSCompleteDTO {
    private List<String> labels;
    private List<ChartJSDatasetDTO> datasets;
    private String type; // 'line', 'bar', 'pie', 'doughnut', 'radar'

    public ChartJSCompleteDTO() {}

    public ChartJSCompleteDTO(List<String> labels, List<ChartJSDatasetDTO> datasets, String type) {
        this.labels = labels;
        this.datasets = datasets;
        this.type = type;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<ChartJSDatasetDTO> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<ChartJSDatasetDTO> datasets) {
        this.datasets = datasets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
