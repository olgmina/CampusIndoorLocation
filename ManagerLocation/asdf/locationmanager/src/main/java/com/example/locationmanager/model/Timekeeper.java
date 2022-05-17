package com.example.locationmanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Timekeeper {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private LocalDateTime startDateTime;
    @NonNull
    private LocalDateTime endDateTime;
    @NonNull
    private String locationId;

    public Timekeeper(LocalDateTime startDateTime, LocalDateTime endDateTime, String locationIdId){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.locationId = locationIdId;
    }
}
