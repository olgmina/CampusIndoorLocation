package com.WorkLess.WorkLess.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ScheduleValidationErrorBuffer {
    public static ScheduleValidationError fromBindingErrors(Errors errors) {
        ScheduleValidationError error = new ScheduleValidationError("Validation" +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
