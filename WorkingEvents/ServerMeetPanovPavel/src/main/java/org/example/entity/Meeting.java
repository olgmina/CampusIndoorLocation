package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "meet")
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

    public Meeting() {
    }

    public Meeting(String name, String location, String descriptions, String localDateTimeStart, String localDateTimeEnd) {
        this.name = name;
        this.location = location;
        this.descriptions = descriptions;
        this.localDateTimeStart = localDateTimeStart;
        this.localDateTimeEnd = localDateTimeEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getLocalDateTimeStart() {
        return localDateTimeStart;
    }

    public void setLocalDateTimeStart(String localDateTimeStart) {
        this.localDateTimeStart = localDateTimeStart;
    }

    public String getLocalDateTimeEnd() {
        return localDateTimeEnd;
    }

    public void setLocalDateTimeEnd(String localDateTimeEnd) {
        this.localDateTimeEnd = localDateTimeEnd;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", localDateTimeStart='" + localDateTimeStart + '\'' +
                ", localDateTimeEnd='" + localDateTimeEnd + '\'' +
                '}';
    }
}
