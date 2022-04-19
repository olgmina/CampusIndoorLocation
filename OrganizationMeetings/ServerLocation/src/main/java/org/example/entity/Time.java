package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "times")
public class Time {
    @Id
    @Column
    int id;
    @Column(name = "time_start")
    String timeStart;

    @Column(name = "time_end")
    String timeEnd;

}