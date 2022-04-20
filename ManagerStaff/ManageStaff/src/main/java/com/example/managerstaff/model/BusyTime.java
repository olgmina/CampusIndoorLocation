package com.example.managerstaff.model;

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
public class BusyTime {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private LocalDateTime startTime;
    @NonNull
    private LocalDateTime endTime;
    @NonNull
    private String staffId;

    public BusyTime(LocalDateTime startTime, LocalDateTime endTime, String staffId){
        this.startTime = startTime;
        this.endTime = endTime;
        this.staffId = staffId;
    }
}
