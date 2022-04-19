package planer;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameGroup;
    private String typeUniversity;
    private String typeWeek;
    private String dayOfWeek;
    private String nameTitle;
    private String organization;
    private Time startData;
    private String endData;
    private String location;

}

