package com.WorkLess.WorkLess.model;

import java.time.LocalTime;

public class ScheduleBuilder {
    private static ScheduleBuilder instance = new ScheduleBuilder();
    private LocalTime startTime = LocalTime.now();
    private LocalTime endTime = LocalTime.now();
    private String day = null;
    private String group = null;
    private String name = null;
    private String teacher = null;
    private String location = null;
    private boolean numeratorOrDenominator = false;

    public static ScheduleBuilder create() {
        return instance;
    }

    public ScheduleBuilder withDay(String day) {
        this.day = day;
        return instance;
    }

    public ScheduleBuilder withTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        return instance;
    }

    public ScheduleBuilder withGroup(String group) {
        this.group = group;
        return instance;
    }

    public ScheduleBuilder withName(String name) {
        this.name = name;
        return instance;
    }

    public ScheduleBuilder withTeacher(String teacher) {
        this.teacher = teacher;
        return instance;
    }

    public ScheduleBuilder withLocation(String location) {
        this.location = location;
        return instance;
    }

    public ScheduleBuilder withNumeratorOrDenominator(boolean numeratorOrDenominator) {
        this.numeratorOrDenominator = numeratorOrDenominator;
        return instance;
    }

    public Schedule build() {
        return new Schedule(this.day, this.startTime, this.endTime, this.group, this.name, this.teacher, this.location, this.numeratorOrDenominator);
    }
}
