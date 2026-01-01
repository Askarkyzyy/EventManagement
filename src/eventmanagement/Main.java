package eventmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager();

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        Event event = new Event(1, eventName, "2025-12-31", "Astana");
        manager.addEvent(event);

        Person p1 = new Participant(1, "Tomiris", "tom@example.com");
        Person p2 = new Participant(2, "Alina", "alina@example.com");

        event.addParticipant((Participant) p1);
        event.addParticipant((Participant) p2);

        manager.sortEventsByName();

        System.out.println("\n=== Events ===");
        manager.showEvents();

        System.out.println("\nPolymorphism test:");
        System.out.println(p1.getRole());

        scanner.close();
    }
}
