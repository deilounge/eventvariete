package pl.eventvariete.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getEventList(String sortBy) {

        if (sortBy == null || sortBy.isBlank()) {
            return eventRepository.findAll();
        } else {
            return eventRepository.findAll(Sort.by(sortBy));
        }
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }
}