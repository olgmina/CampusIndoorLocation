package org.example.entity;

import lombok.Data;


@Data
public class Equipment {
    int id;
    private String Name;
    private String Description;
    private String Conditions;
    private Location equipmentLocation;

    @Override
    public String toString() {
        return
                Name + ' ' +
                Description + ' ' +
                Conditions + " || ";
    }
}
