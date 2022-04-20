package com.example.managerstaff.model;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ManagerStaffBuilder {
    private static ManagerStaffBuilder instance = new ManagerStaffBuilder();
    private String staffId = null;
    private String locationName = "";
    private int auidance = 0;
    private int building = 0;
    private String staffName;
    private LocalDateTime date = LocalDateTime.now();
    private ManagerStaffBuilder(){}

    public static ManagerStaffBuilder create() {
        return instance;
    }

    public ManagerStaffBuilder withLocation(String name, int auidance, int building,String staffName) {
        this.locationName = name;
        this.auidance = auidance;
        this.building = building;
        this.staffName = staffName;
        return instance;
    }
    public ManagerStaffBuilder witTime(LocalDateTime date) {
        this.date = date;
        return instance;
    }

    public ManagerStaffBuilder withStaffId(String memberId) {
        this.staffId = memberId;
        return instance;
    }
    public ManagerStaffBuilder withName(String staffName){
        this.staffName = staffName;
        return instance;
    }

    public ManagerStaff build() {
        ManagerStaff result = new ManagerStaff(this.staffId,this.locationName,this.auidance,
                this.building,this.date,this.staffName);
        if(staffId != null) {
            result.setStaffId(staffId);
        }
        return result;
    }
}
