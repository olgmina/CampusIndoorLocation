package com.example.notifier.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class NotificationValidationErrorBuffer {
    public static NotificationValidationError fromBindingErrors(Errors errors) {
        NotificationValidationError error = new NotificationValidationError("Validation" +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
