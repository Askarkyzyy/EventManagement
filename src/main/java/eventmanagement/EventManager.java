package eventmanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventManager {
    private final ArrayList<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        if(event != null && !events.contains(event)) {
            events.add(event);
        }
    }

    public void showEvents() {
        for(Event e : events) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDate() + " | " + e.getLocation());
        }
    }

    public Event findEventByName(String name) {
        for(Event e : events) {
            if(e.getName().equalsIgnoreCase(name)) return e;
        }
        return null;
    }

    public void sortEventsByName() {
        events.sort(Comparator.comparing(Event::getName));
    }
}
