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

    public List<Event> getEventList(String sortBy, String orderBy, String category) {

        String enumCategory = category.toUpperCase();

        if (category == null) {
            if (sortBy != null && !sortBy.isBlank()) {
                if (orderBy != null && orderBy.equals("desc")) {
                    return eventRepository.findAll(Sort.by(Sort.Direction.DESC, sortBy));
                } else {
                    return eventRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
                }
            } else {
                return eventRepository.findAll();
            }
        } else {
            if (sortBy != null && !sortBy.isBlank()) {
                if (orderBy != null && orderBy.equals("desc")) {
                    return eventRepository.findByTypeOfEvent(TypeOfEvent.valueOf(enumCategory), Sort.by(Sort.Direction.DESC, sortBy));
                } else {
                    return eventRepository.findByTypeOfEvent(TypeOfEvent.valueOf(enumCategory), Sort.by(Sort.Direction.ASC, sortBy));
                }
            } else {
                return eventRepository.findByTypeOfEvent(TypeOfEvent.valueOf(enumCategory), Sort.by(Sort.Direction.DESC, "name"));
            }
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