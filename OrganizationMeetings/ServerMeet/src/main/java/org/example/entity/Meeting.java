package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "meet")
@Data
public class Meeting {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "lacation")
    private String location;

    @Column
    private String descriptions;

    @Column
    private String localDateTimeStart;

    @Column
    private String localDateTimeEnd;

}
