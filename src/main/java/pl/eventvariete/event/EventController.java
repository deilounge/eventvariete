package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    // Lists all events without criteria
    @GetMapping("/")
    public String getMain(){
        return "<html><body><a href='/events'>Lista</a></body></html>";
    }

    // Lists all events without criteria
    @GetMapping("/events")
    public List<Event> getEventList(@RequestParam(required = false) String sortBy){
            return eventService.getEventList(sortBy);
    }

    // Adds one event into db
    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    // Deletes one event in db
    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable(name = "id") Long id){
        eventService.deleteEvent(id);
    }

    // Provides one event from db
    @GetMapping("/events/{id}")
    public Optional<Event> getEvent(@PathVariable(name = "id") Long id){
        return eventService.getEvent(id);
    }
}
