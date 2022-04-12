package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "location")
@Data
public class Location {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Busy busyId;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    private List<Equipment> equipmentList;
    public void addEquipmentInLocation(Equipment equipment){
        if(equipmentList == null){
            equipmentList = new ArrayList<>();
        }
        equipmentList.add(equipment);
    }
}