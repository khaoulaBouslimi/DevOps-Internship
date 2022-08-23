package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Answer;
import tn.esprit.Entity.Question;
import tn.esprit.Repository.AnswerRepository;
import tn.esprit.Repository.QuestionRepository;
@Service
public class AnswerServiceImpl implements IAnswerService {

	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	QuestionRepository questionRepo ;
	
	
	@Override
	public Answer addAnswer(Answer answer, int id) {
		Question q = questionRepo.findById(id).orElse(null);
		answer.setQuestion(q); 
		answerRepository.save(answer);
		
		return answer;
	}

	@Override
	public void deleteAnswerById(Integer id) {
		answerRepository.deleteById(id);
		
	}

	@Override
	public Answer find(Integer id) {
		Answer a = answerRepository.findById(id).orElse(null); 
		return a;
	}

	
/************************************** update Answer *******************************************/	
	
	private void mergeAnswers(Answer currentAnswer, Answer newAnswer) {
		currentAnswer.setAnswertext(newAnswer.getAnswertext());

		if (newAnswer.getAnswerorder() != null) {
			currentAnswer.setAnswerorder(newAnswer.getAnswerorder());
		}
	}
	
	
	@Override
	public Answer update(Answer newAnswer, Integer id) {
		Answer currentAnswer = find(newAnswer.getIdanswer());

		mergeAnswers(currentAnswer, newAnswer);
		return answerRepository.save(currentAnswer);
		
	}
	
	@Override
	public List<Answer> findAnswersByQuestion(int idQuestion) {
		
		return answerRepository.findAnswersByQuestionOrderByOrderAsc(idQuestion);
	}
	

	@Override
	public int countAnswersInQuestion(int idQuestion) {
		
		return answerRepository.countByQuestion(idQuestion);
	}

	@Override
	public Answer saveAnwser(Answer answer) {
		
		return answerRepository.save(answer);
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
