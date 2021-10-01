package pl.eventvariete.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Event<List> {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String preview;
    @Lob
    private String description;
    private String city;
    private String street;
    private Float price;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private String typeOfEvent;
}
