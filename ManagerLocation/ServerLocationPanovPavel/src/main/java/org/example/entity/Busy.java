package org.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class Busy {
    @Id
    @Column
    int id;
    @Column(name = "time_start")
    String timeStart;
    @Column(name = "time_end")
    String timeEnd;
    private List<Location> locationList;
    public void addLocationInTime(Location location){
        if(locationList == null){
            locationList = new ArrayList<>();
        }
        locationList.add(location);
    }

}
