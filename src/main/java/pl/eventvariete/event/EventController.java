package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public List<Event> getEvent(EventService eventService){
        return eventService.getEventList();
    }

    @PostMapping("/")
    public void addEvent(Event event){
        eventService.addEvent(event);
    }
}
