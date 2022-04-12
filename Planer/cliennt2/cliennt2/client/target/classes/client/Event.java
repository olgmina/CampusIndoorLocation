package client;
import lombok.*;

import javax.persistence.*;

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
    private String name_group;
    private String dayOfWeek;
    private String name_title;
    private String organization;
    private String startData;
    private String endData;
    private String location;
}
