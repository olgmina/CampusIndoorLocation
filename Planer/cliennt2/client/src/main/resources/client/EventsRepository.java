package client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event,Long> {
    List<Event> findByLocationAndTypeUniversity(String location,String typeUniversity);
   List<Event> findByNameGroupAndTypeWeekAndDayOfWeek(String nameGroup,String typeWeek,String dayOfWeek);
    List<Event> findByOrganization(String organization);
    List<Event> findByNameTitle(String nameTitle);
}