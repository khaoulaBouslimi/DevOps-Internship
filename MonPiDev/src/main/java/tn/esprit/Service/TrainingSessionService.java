package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Answer;
import tn.esprit.Entity.LikeTs;
import tn.esprit.Entity.TrainingSession;
import tn.esprit.Repository.LikeTsRepository;
import tn.esprit.Repository.TsRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Entity.*;

@Service
public class TrainingSessionService implements ITrainingSessionService {

	@Autowired
	TsRepository tSrepository ;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LikeTsRepository likeTsRepository;
	
	@Override
	public TrainingSession saveTS(TrainingSession ts) {
		tSrepository.save(ts);
		return ts ;
	}

	@Override
	public void deleteTsById(Integer id) {
		tSrepository.deleteById(id); 
		
	}

	@Override
	public List<TrainingSession> getAllTrainingSessions() {
		List<TrainingSession> liste = tSrepository.findAll();
		return liste ;
	}

	@Override
	public TrainingSession findTrainingSession(Integer id) {
		
		TrainingSession ts = tSrepository.findById(id).orElse(null);
		return ts;
	}

	
	
	/************************************** update TS *******************************************/

	private void permutTrainingSession(TrainingSession currentTrainingSession, TrainingSession newTrainingSession) {
		currentTrainingSession.setDescriptionOfTS(newTrainingSession.getDescriptionOfTS());
		
		if (newTrainingSession.getDure() != null){
			currentTrainingSession.setDure(newTrainingSession.getDure());					
		}		
		if (newTrainingSession.getDateDebut() != null){
			currentTrainingSession.setDateDebut(newTrainingSession.getDateDebut());					
		}	
		if (newTrainingSession.getDateFin() != null){
			currentTrainingSession.setDateFin(newTrainingSession.getDateFin());					
		}	
		if (newTrainingSession.getLocalisation() != null){
			currentTrainingSession.setLocalisation(newTrainingSession.getLocalisation());					
		}	
		if (newTrainingSession.getTitle() != null){
			currentTrainingSession.setTitle(newTrainingSession.getTitle());					
		}	
	}
	
	@Override
	public TrainingSession updateTrainingSession(TrainingSession newTrainingSession, Integer id) {
		TrainingSession currentTrainingSession = findTrainingSession(newTrainingSession.getIdTS());
		
		permutTrainingSession(currentTrainingSession, newTrainingSession);
		return tSrepository.save(currentTrainingSession);
	}

	

	/**************************************************************************************************/
	
	
	@Override
	public void AddLikesToTrainingSession(LikeTs likets, int idUser, int idTs) {
		Iterable<User> user = userRepository.findAll();
		for (User user2 : user) {
			if (likeTsRepository.LikesTs(idTs, idUser)==0) {
				if (user2.getId()==idUser) {
					
					tSrepository.findById(idTs).map(c ->{
						
						likets.setInteractionType(InteractionTs.Like);
						likets.setUser(user2);
						likets.setTs(c);
						likets.setLiked(true);
						return c;
						
					});
					
					likeTsRepository.save(likets);
				}
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
