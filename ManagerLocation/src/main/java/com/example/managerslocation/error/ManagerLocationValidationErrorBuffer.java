package com.example.managerlocation.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ManagerLocationValidationErrorBuffer {
    public static ManagerLocationValidationError fromBindingErrors(Errors errors) {
        ManagerLocationValidationError error = new ManagerLocationValidationError("Validation" +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
