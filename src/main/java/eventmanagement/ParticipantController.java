package eventmanagement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantDAO participantDAO = new ParticipantDAO();

    @PostMapping("/{eventId}")
    public String addParticipant(
            @PathVariable int eventId,
            @RequestBody Participant participant) {

        participantDAO.addParticipant(participant, eventId);
        return "Participant added";
    }

    @DeleteMapping("/{id}")
    public String deleteParticipant(@PathVariable int id) {
        participantDAO.deleteParticipant(id);
        return "Participant deleted";
    }
}