package com.example.managerasserts.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ManagerAsserts {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String assertId;
    @NonNull
    private int floor;
    @NonNull
    private int building;
    @NonNull
    private String locationName;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private String assertName;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public ManagerAsserts(String assertId, String locationName, int floor, int building, LocalDateTime date,String assertName ) {
        this.assertId = assertId;
        this.assertName = assertName;
        Location location = new Location(locationName, floor, building);
        this.locationName = location.getName();
        this.floor = location.getFloor();
        this.building = location.getBuilding();
        this.date = date;
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(LocalDateTime.now());
        this.setModifiedTime(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        this.setModifiedTime(LocalDateTime.now());
    }
}
