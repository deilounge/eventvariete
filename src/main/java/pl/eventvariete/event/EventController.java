package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public List<Event> getEvent(){
        return eventService.getEventList();
    }

    @PostMapping("/")
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }
}
