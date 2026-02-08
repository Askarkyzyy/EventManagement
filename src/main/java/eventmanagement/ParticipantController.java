package eventmanagement;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantDAO participantDAO = new ParticipantDAO();

    // -------------------------------
    // GET /participants — получить всех участников
    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantDAO.getAllParticipants();
    }

    // -------------------------------
    // GET /participants/{id} — получить участника по id
    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable int id) {
        return participantDAO.getAllParticipants()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Participant not found"));
    }

    // -------------------------------
    // GET /participants/search?name=Tom — поиск по имени
    @GetMapping("/search")
    public List<Participant> findByName(@RequestParam String name) {
        return participantDAO.getAllParticipants()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }

    // -------------------------------
    // GET /participants/sorted — сортировка по имени
    @GetMapping("/sorted")
    public List<Participant> getSortedParticipants() {
        List<Participant> participants = participantDAO.getAllParticipants();
        participants.sort(Comparator.comparing(Participant::getName));
        return participants;
    }

    // -------------------------------
    // POST /participants — создать участника
    @PostMapping
    public ResponseEntity<String> createParticipant(@RequestBody Participant participant) {
        participantDAO.addParticipant(participant);
        return ResponseEntity.ok("Participant created");
    }

    // -------------------------------
    // PUT /participants/{id} — обновить участника
    @PutMapping("/{id}")
    public ResponseEntity<String> updateParticipant(
            @PathVariable int id,
            @RequestBody Participant participant
    ) {
        participant.setId(id);
        participantDAO.updateParticipant(participant);
        return ResponseEntity.ok("Participant updated");
    }

    // -------------------------------
    // DELETE /participants/{id} — удалить участника
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParticipant(@PathVariable int id) {
        participantDAO.deleteParticipant(id);
        return ResponseEntity.ok("Participant deleted");
    }
}
