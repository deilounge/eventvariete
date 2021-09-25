package pl.eventvariete.event;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String city;
    /*private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private TypeOfEvent typeOfEvent;
*/
}
