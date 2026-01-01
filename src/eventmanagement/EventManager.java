package eventmanagement;

import java.util.ArrayList;
import java.util.Comparator;
public class EventManager {
    private ArrayList<Event> events;
    private ArrayList<Participant> participants;

    // Constructor
    public EventManager() {
        events = new ArrayList<>();
        participants = new ArrayList<>();
    }

    // Add a new event
    public void addEvent(Event event) {
        events.add(event);
    }

    // Add a new participant
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    // Display all events
    public void showEvents() {
        for (Event e : events) {
            System.out.println("ID: " + e.getId() +
                    ", Name: " + e.getName() +
                    ", Date: " + e.getDate() +
                    ", Location: " + e.getLocation());
        }
    }

    // Display all participants
    public void showParticipant(){
        for (Participant p : participants){
            System.out.println("ID: " + p.getId() +
                    ", Name: " + p.getName() +
                    ",  Email: " + p.getEmail());
        }
    }
    public Event findEventByName(String name) {
        for (Event e : events) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }


    public void sortEventsByName() {
        events.sort(Comparator.comparing(Event::getName));
    }

}