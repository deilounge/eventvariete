package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "<html><body><a href='/list'>Lista</a></body></html>";
    }

    // Lists all events without criteria
    @GetMapping("/list")
    public List<Event> getEventList(){
        return eventService.getEventList();
    }

    // Adds one event into db
    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    // Deletes one event in db
    @GetMapping("/delete/{id}")
    public void deleteEvent(@PathVariable(name = "id") Long id){
        System.out.println(id);
        eventService.deleteEvent(id);
    }

    // Provides one event from db
    @GetMapping("/get/{id}")
    public Optional<Event> getEvent(@PathVariable(name = "id") Long id){
        return eventService.getEvent(id);
    }
}
