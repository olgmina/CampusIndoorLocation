package org.example.entity;

import lombok.Data;

import java.util.List;


@Data
public class Location {
    private int id;
    private String name;
    private String description;

    private Time locationTime;
    private List<Equipment> equipmentList;

}