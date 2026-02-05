package eventmanagement;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventDAO eventDAO = new EventDAO();

    // GET /events
    /*@GetMapping
    public void getAllEvents() {
        eventDAO.showEvents(); // вывод в консоль (допустимо для простого проекта)
    }

    // GET /events/{id}
    @GetMapping("/{id}")
    public String getEventById(@PathVariable int id) {
        return "Event with id = " + id;
    }*/

    // POST /events
    @PostMapping
    public String createEvent(@RequestBody Event event) {
        eventDAO.addEvent(event);
        return "Event created";
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    // PUT /events/{id}
    @PutMapping("/{id}")
    public String updateEvent(@PathVariable int id, @RequestBody Event event) {
        event.setId(id);
        eventDAO.updateEvent(event);
        return "Event updated";
    }
    // DELETE /events/{id}
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventDAO.deleteEvent(id);
        return "Event deleted";
    }
}

