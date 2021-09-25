package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getEventList() {
        return eventRepository.findAll();
    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}
