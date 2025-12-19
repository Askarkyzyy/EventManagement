package eventmanagement;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        // Create events
        Event event1 = new Event(1, "Music Party", "2025-12-31", "Astana");
        Event event2 = new Event(2, "Sports Tournament", "2025-05-10", "Almaty");

        // Create participants
        Participant participant1 = new Participant(1, "Tomiris", "tom@example.com");
        Participant participant2 = new Participant(2, "Alina", "alina@example.com");

        // Add events and participants to manager
        manager.addEvent(event1);
        manager.addEvent(event2);
        manager.addParticipant(participant1);
        manager.addParticipant(participant2);

        // Display all events and participants
        System.out.println("All Events:");
        manager.showEvents();

        System.out.println("\nAll Participants:");
        manager.showParticipants();
    }
}