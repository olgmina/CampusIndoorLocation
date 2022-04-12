package com.example.managerasserts.model;

import java.time.LocalDateTime;

public class ManagerAssertsBuilder {
    private static ManagerAssertsBuilder instance = new ManagerAssertsBuilder();
    private String assetId = null;
    private String locationName = "";
    private int floor = 0;
    private int building = 0;
    private String assertName;
    private LocalDateTime date = LocalDateTime.now();
    private ManagerAssertsBuilder(){}

    public static ManagerAssertsBuilder create() {
        return instance;
    }

    public ManagerAssertsBuilder withLocation(String name, int floor, int building, String address) {
        this.locationName = name;
        this.floor = floor;
        this.building = building;
        return instance;
    }
    public ManagerAssertsBuilder witTime(LocalDateTime date) {
        this.date = date;
        return instance;
    }

    public ManagerAssertsBuilder withAssetId(String memberId) {
        this.assetId = memberId;
        return instance;
    }
    public ManagerAssertsBuilder withName(String assertName){
        this.assertName = assertName;
        return instance;
    }

    public ManagerAsserts build() {
        ManagerAsserts result = new ManagerAsserts(this.assetId,this.locationName,this.floor,
                this.building,this.date,this.assertName);
        if(assetId != null) {
            result.setAssertId(assetId);
        }
        return result;
    }
}
