package upc.com.visiontech2.dto;

public class ChartDataDTO {
    private String label;
    private Object value;
    private String backgroundColor;
    private String borderColor;

    public ChartDataDTO() {}

    public ChartDataDTO(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public ChartDataDTO(String label, Object value, String backgroundColor, String borderColor) {
        this.label = label;
        this.value = value;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
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
}
