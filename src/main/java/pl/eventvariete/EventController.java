package pl.eventvariete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/")
    public String getEvent(){
        return "Witaj w naszej nowej aplikacji";
    }
}
