package upc.com.visiontech2.dto;

import java.util.List;

public class ChartJSDatasetDTO {
    private String label;
    private List<Object> data;
    private String backgroundColor;
    private String borderColor;
    private Integer borderWidth;
    private String type; // 'line', 'bar', 'pie', 'doughnut'

    public ChartJSDatasetDTO() {}

    public ChartJSDatasetDTO(String label, List<Object> data, String backgroundColor, String borderColor) {
        this.label = label;
        this.data = data;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderWidth = 1;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
