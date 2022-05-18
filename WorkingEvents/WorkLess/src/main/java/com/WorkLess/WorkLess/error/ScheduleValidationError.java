package com.WorkLess.WorkLess.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ScheduleValidationError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();
    private final String errorMessage;

    public ScheduleValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public void addValidationError(String error) {
        errors.add(error);
    }
    public List<String> getErrors() {
        return errors;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
