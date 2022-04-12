package org.example.entity;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class Equipment {
    @Id
    @Column
    int id;

    @Column
    String name;

    @Column
    private String description;


}
