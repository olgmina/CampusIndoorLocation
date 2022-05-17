package com.example.locationmanager.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class LocationValidationErrorBuffer {
    public static LocationValidationError fromBindingErrors(Errors errors) {
        LocationValidationError error = new LocationValidationError("Validation" +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
