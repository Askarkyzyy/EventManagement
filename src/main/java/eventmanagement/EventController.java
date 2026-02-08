package eventmanagement;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventDAO eventDAO = new EventDAO();

    // -------------------------------
    // GET /events — получить все события
    @GetMapping
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    // -------------------------------
    // GET /events/{id} — получить событие по id
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventDAO.getAllEvents()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Event not found"));
    }

    // -------------------------------
    // GET /events/search?location=Astana — фильтрация по location
    @GetMapping("/search")
    public List<Event> findByLocation(@RequestParam String location) {
        return eventDAO.getAllEvents()
                .stream()
                .filter(e -> e.getLocation().equalsIgnoreCase(location))
                .toList();
    }

    // -------------------------------
    // GET /events/sorted — сортировка по имени
    @GetMapping("/sorted")
    public List<Event> getSortedEvents() {
        List<Event> events = eventDAO.getAllEvents();
        events.sort(Comparator.comparing(Event::getName));
        return events;
    }

    // -------------------------------
    // POST /events — создать новое событие
    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        eventDAO.addEvent(event);
        return ResponseEntity.ok("Event created");
    }

    // -------------------------------
    // PUT /events/{id} — обновить событие
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable int id, @RequestBody Event event) {
        event.setId(id);
        eventDAO.updateEvent(event);
        return ResponseEntity.ok("Event updated");
    }

    // -------------------------------
    // DELETE /events/{id} — удалить событие
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        eventDAO.deleteEvent(id);
        return ResponseEntity.ok("Event deleted");
    }
}
