package hw.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import hw.Participant;

@Repository
public class ParticipantRepo {

	private List<Participant> participants = new ArrayList();

	@PostConstruct
	public void init() {

		Participant participant = new Participant();
		participant.setName("Max");
		participant.setEmail("max@gmail.com");
		participant.setId(1);

//		Participant participant2 = new Participant();
//		participant.setName("Ivan");
//		participant.setEmail("ivan@gmail.com");
//		participant.setId(2);
//		
//		Participant participant3 = new Participant();
//		participant.setName("Petro");
//		participant.setEmail("petro@gmail.com");
//		participant.setId(3);
		
		participants.add(participant);
//		participants.add(participant2);
//		participants.add(participant3);

	}

	public List<Participant> AllParticipant() {
		return participants;
	}

	public Participant findOne(Integer id) {
		return participants.stream().filter(participants -> participants.getId() == id).findFirst().orElse(null);
			

	}

	public void save(Participant participant) {
		
		Participant participantToUpdate = null;
		
		if(participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participants.set(participantIndex, participantToUpdate);
			
		}else {
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
		
	}

	public void remove(Integer id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
	
	
}
