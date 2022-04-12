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
    public String getLocation(Model model){

        return "location_page";
    }
    @GetMapping("/Find")
    public String FindLoc( String location,Model model) {
        List<Event> event = eventsRepository.findByLocation(location);
        model.addAttribute("events", event);
        return "events_page";




    }
}


