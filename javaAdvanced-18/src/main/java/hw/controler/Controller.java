package hw.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hw.Participant;
import hw.service.ParticipantService;

@org.springframework.stereotype.Controller
public class Controller  {

	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("participants", participantService.AllParticipant());
		request.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
	
	@GetMapping("/new")
	public String newPartipicant(HttpServletRequest request) {
		request.setAttribute("mode", "PARTICIPANT_CREATE");
		return "index";
	}
	
	@RequestMapping(path = {"/save"}, method = RequestMethod.POST)
	public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
		participantService.save(participant);
		request.setAttribute("participants", participantService.AllParticipant());
		request.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("participant", participantService.findOne(id));
		request.setAttribute("mode", "PARTICIPANT_EDIT");
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam int id, HttpServletRequest request) {
		participantService.remove(id);
		request.setAttribute("participants", participantService.AllParticipant());
		request.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
	
}
