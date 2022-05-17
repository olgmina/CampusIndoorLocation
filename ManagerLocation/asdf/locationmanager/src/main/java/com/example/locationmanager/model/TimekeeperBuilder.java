package com.example.locationmanager.model;

import java.time.LocalDateTime;

public class TimekeeperBuilder {
    private static TimekeeperBuilder instance = new TimekeeperBuilder();
    private LocalDateTime startDateTime = LocalDateTime.now();
    private LocalDateTime endDateTime = LocalDateTime.now();
    private String locationId = null;

    public static TimekeeperBuilder create() {
        return instance;
    }

    public TimekeeperBuilder withLocationId(String locationId) {
        this.locationId = locationId;
        return instance;
    }

    public TimekeeperBuilder withTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        return instance;
    }

    public Timekeeper build() {
        return new Timekeeper(this.startDateTime, this.endDateTime, this.locationId);
    }
}
