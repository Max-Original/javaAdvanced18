package hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hw.Participant;
import hw.dao.ParticipantRepo;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepo participantRepo;
	
	public List<Participant> AllParticipant() {
		return participantRepo.AllParticipant();
	}

	public Participant findOne(Integer id) {
		return participantRepo.findOne(id);

	}

	public void save(Participant participant) {
		
        participantRepo.save(participant);
	
	}

	public void remove(Integer id) {
		participantRepo.remove(id);
}
}