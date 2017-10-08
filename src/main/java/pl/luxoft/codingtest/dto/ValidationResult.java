package pl.luxoft.codingtest.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private String tcn;
    private String type;
    private List<String> errorMessage = new ArrayList<>();

    public String getTcn() {
        return tcn;
    }

    public void setTcn(String tcn) {
        this.tcn = tcn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }
}
