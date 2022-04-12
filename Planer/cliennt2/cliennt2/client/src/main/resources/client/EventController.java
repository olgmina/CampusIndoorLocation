package client;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class EventController {

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping("/event")
    public String getEventsPage(Model model){
        List<Event> events=eventsRepository.findAll();
        model.addAttribute("events",events);
        return "events_page";
    }



}
