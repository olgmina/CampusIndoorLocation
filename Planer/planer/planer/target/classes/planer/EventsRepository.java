package planer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;

public interface EventsRepository extends JpaRepository<Event,Long> {
    List<Event> findByLocationAndTypeUniversity(String location,String typeUniversity);
   List<Event> findByNameGroupAndTypeWeekAndDayOfWeek(String nameGroup,String typeWeek,String dayOfWeek);
    List<Event> findByOrganization(String organization);
    List<Event> findByNameTitle(String nameTitle);
    @Query("select e from Event e where e.startData = ?1")
     List<Event> findByStartData(Time startData) ;


    }



