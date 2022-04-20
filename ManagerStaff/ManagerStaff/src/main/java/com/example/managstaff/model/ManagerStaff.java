package com.example.managstaff.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ManagerStaff {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String staffId;
    @NonNull
    private int floor;
    @NonNull
    private int building;
    @NonNull
    private String locationName;
    @NonNull
    private boolean status;
    @NotNull
    @Column(name="`DATE`")
    private LocalDateTime date;
    @NonNull
    private String staffName;
    @Column(insertable = true, updatable = false)
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public ManagerStaff(String staffId, String locationName, int floor, int building, LocalDateTime date,
                        String staffName, boolean status ) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.status = status;
        Location location = new Location(locationName, floor, building);
        this.locationName = location.getName();
        this.floor = location.getFloor();
        this.building = location.getBuilding();
        this.date = date;
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(LocalDateTime.now());
        this.status = true;
        this.setModifiedTime(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        this.setModifiedTime(LocalDateTime.now());
    }

    public boolean isStatus() {
        return status;
    }
}
