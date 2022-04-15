package com.example.managerasserts.model;

import java.time.LocalDateTime;

public class ManagerStaffBuilder {
    private static ManagerStaffBuilder instance = new ManagerStaffBuilder();
    private String assetId = null;
    private String locationName = "";
    private int auidance = 0;
    private int building = 0;
    private String assertName;
    private LocalDateTime date = LocalDateTime.now();
    private ManagerStaffBuilder(){}

    public static ManagerStaffBuilder create() {
        return instance;
    }

    public ManagerStaffBuilder withLocation(String name, int auidance, int building, String address) {
        this.locationName = name;
        this.auidance = auidance;
        this.building = building;
        return instance;
    }
    public ManagerStaffBuilder witTime(LocalDateTime date) {
        this.date = date;
        return instance;
    }

    public ManagerStaffBuilder withAssetId(String memberId) {
        this.assetId = memberId;
        return instance;
    }
    public ManagerStaffBuilder withName(String assertName){
        this.assertName = assertName;
        return instance;
    }

    public ManagerStaff build() {
        ManagerStaff result = new ManagerStaff(this.assetId,this.locationName,this.auidance,
                this.building,this.date,this.assertName);
        if(assetId != null) {
            result.setAssertId(assetId);
        }
        return result;
    }
}
