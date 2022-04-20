package com.example.managstaff.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ManagerStaffValidationErrorBuffer {
    public static ManagerStaffValidationError fromBindingErrors(Errors errors) {
        ManagerStaffValidationError error = new ManagerStaffValidationError("Validation" +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
