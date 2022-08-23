package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.InteractionTs;
import tn.esprit.Entity.LikeTs;
import tn.esprit.Repository.LikeTsRepository;
import tn.esprit.Repository.TsRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Entity.User;


@Service
public class LikeTsService implements ILikeTsService {
	
	@Autowired
	LikeTsRepository likeTsRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TsRepository TsRepository;


	
	
	@Override
	public void AddLikesToTrainingSession(LikeTs likets, int idUser, int idTs) {
		Iterable<User> user = userRepository.findAll();
		for (User user2 : user) {
			if (likeTsRepository.LikesTs(idTs, idUser)==0) {
				if (user2.getId()==idUser) {
					
					TsRepository.findById(idTs).map(c ->{
						
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




	@Override
	public void AddDislikeToTrainingSession(LikeTs likes, int user_id, int idTs) {
		Iterable<User> user = userRepository.findAll();
		for (User user2 : user) {
		if (likeTsRepository.DislikesTs(idTs, user_id)==0) {
			
				if (user2.getId()== user_id) {
					TsRepository.findById(idTs).map(p -> {
						  likes.setInteractionType(InteractionTs.Dislike);
						  likes.setTs(p);
						  likes.setUser(user2);
						  likes.setLiked(false);
						  System.out.println("ok");
							
							return p;
					  });

				
				
			}
			
				likeTsRepository.save(likes);
		}
		
		}
		
	}




	@Override
	public void Deletelike(int idUser,int idTs) {
		if (likeTsRepository.FindUserByIdFromLikes(idUser, idTs)==1){
			likeTsRepository.DeleteLike(idUser, idTs);}
		
	}




	@Override
	public void DeleteDislike(int idUser,int idTs) {
		if (likeTsRepository.FindUserByIdFromDislikes(idUser, idTs)==1){
			
			likeTsRepository.DeleteDisLike(idUser, idTs);
			
		}
		
	}
	

}
