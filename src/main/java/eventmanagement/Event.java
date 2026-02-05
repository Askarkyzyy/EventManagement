package eventmanagement;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private String description; // новая колонка
    private final ArrayList<Participant> participants = new ArrayList<>();

    // Конструктор с description
    public Event(int id, String name, String date, String location, String description) {
        this.id = id > 0 ? id : 1;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { if(id > 0) this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { if(name != null && !name.isEmpty()) this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public void addParticipant(Participant participant) {
        if(participant != null && !participants.contains(participant)) {
            participants.add(participant);
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", participants=" + participants.size() +
                '}';
    }
}
