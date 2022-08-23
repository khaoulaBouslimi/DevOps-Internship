package tn.esprit.Service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.Entity.Question;
import tn.esprit.Entity.Quiz;
import tn.esprit.Entity.User;
import tn.esprit.Entity.Response;



public interface IQuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz save(Quiz quiz, User user);

	Page<Quiz> findAll(Pageable pageable);

	Page<Quiz> findAllPublished(Pageable pageable);

//	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);
//
	public Quiz find(Integer id) ;

	Quiz update(Quiz currentquiz,  Integer idQuiz) ;

	void deleteById(Integer id) ;

	Page<Quiz> search(String query, Pageable pageable);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
	
	Question addQuestionToQuiz(Question q , Integer idQuiz);
	
	
}
