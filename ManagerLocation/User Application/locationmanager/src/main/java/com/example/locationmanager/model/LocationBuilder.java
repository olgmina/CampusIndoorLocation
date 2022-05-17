package com.example.locationmanager.model;

public class LocationBuilder {
    private static LocationBuilder instance = new LocationBuilder();
    private int classroom = 0;
    private int floor = 0;
    private int building = 0;
    private String address = null;
    private boolean status = false;

    public static LocationBuilder create() {
        return instance;
    }

    public LocationBuilder withClassroom(int classroom) {
        this.classroom = classroom;
        return instance;
    }

    public LocationBuilder withFloor(int floor) {
        this.floor = floor;
        return instance;
    }

    public LocationBuilder withBuilding(int building) {
        this.building = building;
        return instance;
    }

    public LocationBuilder withAddress(String address) {
        this.address = address;
        return instance;
    }

    public LocationBuilder withStatus(boolean status) {
        this.status = status;
        return instance;
    }

    public Location build() {
        return new Location(this.classroom, this.floor, this.building, this.address, this.status);
    }
}
