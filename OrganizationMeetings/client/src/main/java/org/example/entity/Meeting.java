package org.example.entity;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class Meeting {
    private int id;
    private String name;
    private String location;
    private String descriptions;
    @Pattern(regexp = "\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d", message="используйте паттерн xxxx-xx-xx xx:xx:xx")
    private String localDateTimeStart;
    @Pattern(regexp = "\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d", message="используйте паттерн xxxx-xx-xx xx:xx:xx")
    private String localDateTimeEnd;

}
