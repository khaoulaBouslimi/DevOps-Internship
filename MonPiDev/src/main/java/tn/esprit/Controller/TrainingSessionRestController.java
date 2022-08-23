package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Answer;
import tn.esprit.Entity.LikeTs;
import tn.esprit.Entity.Question;
import tn.esprit.Entity.TrainingSession;
import tn.esprit.Service.ITrainingSessionService;
import tn.esprit.Entity.*;

@RestController
public class TrainingSessionRestController {

	@Autowired
	ITrainingSessionService iTrainingSessionService;
	
	
	
	@PostMapping("/addTheTrainingSession")
	@ResponseBody
	public TrainingSession saveTS(@RequestBody TrainingSession ts) {
		return iTrainingSessionService.saveTS(ts);
	}
	
	
	
	@DeleteMapping("/DeleteTheTrainingSessionById/{trainingSessionId}")
	@ResponseBody
	public void deleteTsById(@PathVariable("trainingSessionId") Integer id) {
		iTrainingSessionService.deleteTsById(id);
	}
	
	
	
	
	@GetMapping("GetAllTrainingSessions")
	@ResponseBody
	public List<TrainingSession> getAllTrainingSessions() {
		List<TrainingSession> liste = iTrainingSessionService.getAllTrainingSessions();
		return liste ;
	}
	
	
	
	
	@GetMapping("GetTrainingSessionById/{trainingSessionId}")
	@ResponseBody
	public TrainingSession findTrainingSession(@PathVariable("trainingSessionId") Integer id) {
		return iTrainingSessionService.findTrainingSession(id);
	}
	

	
	@PutMapping("/updateTrainingSession/{idTS}")
	@ResponseBody
	public TrainingSession updateTrainingSession(@RequestBody TrainingSession ts,@PathVariable("idTS") int idTS) {
		ts.setIdTS(idTS);
		return iTrainingSessionService.updateTrainingSession(ts, idTS);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
