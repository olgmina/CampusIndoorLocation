package com.example.managstaff.model;

public class Location {
    private String name;
    private int floor;
    private int building;

    public Location(String name, int floor, int building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public int getBuilding() {
        return building;
    }

}
