package com.example.locationmanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private int classroom;
    @NonNull
    private int floor;
    @NonNull
    private int building;
    @NonNull
    private String address;
    @NonNull
    private boolean status;

    public Location(int classroom, int floor, int building, String address, boolean status) {
        this.classroom = classroom;
        this.floor = floor;
        this.building = building;
        this.address = address;
        this.status = status;
    }
}
