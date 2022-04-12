package com.example.notifier;

import com.example.notifier.error.NotificationValidationError;
import com.example.notifier.error.NotificationValidationErrorBuffer;
import com.example.notifier.model.Notification;
import com.example.notifier.model.NotificationBuilder;
import com.example.notifier.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api")
public class NotificationController {
    private NotificationRepository repository;

    @Autowired
    public NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/notifications")
    public ResponseEntity<Iterable<Notification>> getNotifications(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/notifications/{eventId}")
    public ResponseEntity<Iterable<Notification>> getNotificationByEventId(@PathVariable String eventId){
        return ResponseEntity.ok(repository.findByEventId(eventId));
    }

    @PutMapping("/notification/add")
    public ResponseEntity<?> addNotification(@Validated @RequestBody Notification notification, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(NotificationValidationErrorBuffer.fromBindingErrors(errors));
        }
        Notification result = repository.save(notification);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getEventId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Notification> deleteNotification(@RequestBody Notification notification){
        repository.delete(notification);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public NotificationValidationError handleException(Exception exception) {
        return new NotificationValidationError(exception.getMessage());
    }
}
