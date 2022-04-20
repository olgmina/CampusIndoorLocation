package com.example.managerstaff.model;

import java.time.LocalDateTime;

public class ManagerStaffBuilder {
    private static ManagerStaffBuilder instance = new ManagerStaffBuilder();
    private String staffId = null;
    private String locationName = "";
    private int floor = 0;
    private int building = 0;
    private String staffName;
    private boolean status = true;
    private LocalDateTime date = LocalDateTime.now();
    private ManagerStaffBuilder(){}

    public static ManagerStaffBuilder create() {
        return instance;
    }

    public ManagerStaffBuilder withLocation(String name, int floor, int building) {
        this.locationName = name;
        this.floor = floor;
        this.building = building;
        return instance;
    }
    public ManagerStaffBuilder witTime(LocalDateTime date, boolean status) {
        this.date = date;
        this.status = status;
        return instance;
    }

    public ManagerStaffBuilder withStaffId(String staffId) {
        this.staffId = staffId;
        return instance;
    }
    public ManagerStaffBuilder withName(String staffName){
        this.staffName = staffName;
        return instance;
    }

    public ManagerStaff build() {
        ManagerStaff result = new ManagerStaff(this.staffId,this.locationName,this.floor,
                this.building,this.date,this.staffName,this.status);
        if(staffId != null) {
            result.setStaffId(staffId);
        }
        return result;
    }
}
