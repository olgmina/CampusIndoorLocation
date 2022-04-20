package com.example.managerstaff.model;

public class Staff {

    private String name;
    private int audiance;
    private int building;

    public Staff(String name, int audiance, int building) {
        this.name = name;
        this.audiance=audiance;
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public int getAudiance() {
        return audiance;
    }

    public int getBuilding() {
        return building;
    }

}
