package tn.esprit.Service;


import java.util.List;

import tn.esprit.Entity.Answer;

public interface IAnswerService {

	public Answer addAnswer(Answer answer, int id);
	
	public Answer saveAnwser(Answer answer);
	
	public Answer find(Integer id) ;
	
	public Answer update(Answer newAnswer, Integer id) ;
	
	public void deleteAnswerById(Integer id);
	
	public List<Answer> findAnswersByQuestion(int idQuestion);
	
	public int countAnswersInQuestion(int idQuestion);
	
	
}
