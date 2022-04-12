package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping("/location")
    public String getLocation(Model model) {

        return "location_page";
    }

    @GetMapping("/Find")
    public String FindLoc(String location, String typeUniversity, Model model) {
        List<Event> event = eventsRepository.findByLocationAndTypeUniversity(location, typeUniversity);
        model.addAttribute("events", event);
        return "events_page";


    }

    @GetMapping("/dayOfWeek")
    public String getDayOfWeek(Model model) {

        return "dayOfWeek_page";
    }

    @GetMapping("/Find2")
    public String FindDay(String nameGroup, String typeWeek, String dayOfWeek, Model model) {
        List<Event> event2 = eventsRepository.findByNameGroupAndTypeWeekAndDayOfWeek(nameGroup, typeWeek, dayOfWeek);
        model.addAttribute("events", event2);
        return "events_page";
    }

    @GetMapping("/Org")
    public String getOrganization(Model model) {

        return "organizator_page";
    }

    @GetMapping("/Find3")
    public String FindOrganizator(String organization, Model model) {
        List<Event> event3 = eventsRepository.findByOrganization(organization);
        model.addAttribute("events", event3);
        return "events_page";
    }

    @GetMapping("/name")
    public String getName(Model model) {

        return "name_page";
    }

    @GetMapping("/Find4")
    public String FindName(String nameTitle, Model model) {
        List<Event> event4 = eventsRepository.findByNameTitle(nameTitle);
        model.addAttribute("events", event4);
        return "events_page";

    }
}



