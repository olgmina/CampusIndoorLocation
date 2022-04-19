package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "equipmentLocation")
    private List<Equipment> equipmentList;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time locationTime;

}