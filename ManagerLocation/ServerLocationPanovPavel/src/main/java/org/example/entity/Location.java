package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "location")
@Data
public class Location {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Busy busyId;


}
