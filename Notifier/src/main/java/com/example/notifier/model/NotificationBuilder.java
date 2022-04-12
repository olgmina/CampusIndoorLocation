package com.example.notifier.model;

public class NotificationBuilder {
    private static NotificationBuilder instance = new NotificationBuilder();
    private String eventId = null;
    private String memberId = null;

    private NotificationBuilder(){}

    public static NotificationBuilder create() {
        return instance;
    }

    public NotificationBuilder withEventId(String eventId) {
        this.eventId = eventId;
        return instance;
    }
    public NotificationBuilder withMemberId(String memberId) {
        this.memberId = memberId;
        return instance;
    }

    public Notification build() {
        Notification result = new Notification(this.eventId, this.memberId);
        if(eventId != null) {
            result.setEventId(eventId);
        }
        return result;
    }
}
