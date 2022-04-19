package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column
    int id;

    @Column(name = "name")
    private String Name;

    @Column(name = "description")
    private String Description;


    @Column(name = "conditions")
    private String Conditions;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location equipmentLocation;

}
