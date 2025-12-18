package eventmanagement;
import java.util.ArrayList;
public class EventManager {
    private ArrayList<Event> events;
    private ArrayList<Participiant> participants;

    // Add a new event
    public void addEvent(Event event) {
        events.add(event);
    }

    // Add a new participant
    public void addParticipant(Participiant participant) {
        participants.add(participant);
    }
}
