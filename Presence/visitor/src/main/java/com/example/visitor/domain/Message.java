package com.example.visitor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Message extends AbstractMessage{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String event;

    private String topicName;

    private String visitor;

    private String comment;

    public Message() {
    }

    public Message(String event, String topicName, String visitor, String comment) {
        this.event = event;
        this.topicName = topicName;
        this.visitor = visitor;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
