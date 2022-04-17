package com.example.managerlocation.model;

import com.example.managerslocation.model.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ManagerLocation {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String locationId;
    @NonNull
    private int floor;
    @NonNull
    private int building;
    @NonNull
    private String locationName;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private String locationName;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public ManagerLocation(String locationId, String locationName, int floor, int building, LocalDateTime date,String locationName ) {
        this.locationId = locationId;
        this.locationName = locationName;
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
