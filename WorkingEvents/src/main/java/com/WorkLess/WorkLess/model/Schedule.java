package com.WorkLess.WorkLess.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Schedule {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String day;
    @NonNull
    private LocalTime startTime;
    @NonNull
    private LocalTime endTime;
    @NonNull
    @Column(name="`GROUP`")
    private String group;
    @NonNull
    private String name;
    @NonNull
    private String teacher;
    @NonNull
    private String location;
    @NonNull
    private boolean numeratorOrDenominator;

    public Schedule(String day, LocalTime startTime, LocalTime endTime, String group, String name, String teacher, String location, boolean numeratorOrDenominator){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.group = group;
        this.name = name;
        this.teacher = teacher;
        this.location = location;
        this.numeratorOrDenominator = numeratorOrDenominator;
    }
}
