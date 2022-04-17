package com.example.managerslocation.model;

import java.time.LocalDateTime;

public class ManagerLocationBuilder {
    private static ManagerLocationBuilder instance = new ManagerLocationBuilder();
    private String locationId = null;
    private String locationName = "";
    private int floor = 0;
    private int building = 0;
    private String locationName;
    private LocalDateTime date = LocalDateTime.now();
    private ManagerLocationBuilder(){}

    public static ManagerLocationBuilder create() {
        return instance;
    }

    public ManagerLocationBuilder withLocation(String name, int floor, int building, String address) {
        this.locationName = name;
        this.floor = floor;
        this.building = building;
        return instance;
    }
    public ManagerLocationBuilder witTime(LocalDateTime date) {
        this.date = date;
        return instance;
    }

    public ManagerLocationBuilder withAssetId(String memberId) {
        this.locationId = memberId;
        return instance;
    }
    public ManagerLocationBuilder withName(String locationName){
        this.locationName = locationName;
        return instance;
    }

    public ManagerLocation build() {
        ManagerLocation result = new ManagerLocation(this.locationId,this.locationName,this.floor,
                this.building,this.date,this.locationName);
        if(locationId != null) {
            result.setLocationId(locationId);
        }
        return result;
    }
}
