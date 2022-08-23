package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Question implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQuestion;

	private Integer questionorder;
	
	@Size(min = 2, max = 1500, message = "The question should be between 2 and 1500 characters")
	@NotBlank(message = "Question text not provided")
	private String questiontext;

	private Boolean isvalid = false;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answer> answers;

	
	@OneToOne
	@JsonIgnore
	private Answer correctAnswer;

	@ManyToOne
	@JoinColumn(name="idquiz")
	@JsonIgnore
	private Quiz quiz;
	
	
	public Question(Integer questionorder,
			@Size(min = 2, max = 1500, message = "The question should be between 2 and 1500 characters") @NotBlank(message = "Question text not provided") String questiontext) {
		super();
		this.questionorder = questionorder;
		this.questiontext = questiontext;
	}


	public Question(Integer questionorder,
			@Size(min = 2, max = 1500, message = "The question should be between 2 and 1500 characters") @NotBlank(message = "Question text not provided") String questiontext,
			Boolean isvalid) {
		super();
		this.questionorder = questionorder;
		this.questiontext = questiontext;
		this.isvalid = isvalid;
	}


	public int getIdQuestion() {
		return idQuestion;
	}


	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}


	public Integer getQuestionorder() {
		return questionorder;
	}


	public void setQuestionorder(Integer questionorder) {
		this.questionorder = questionorder;
	}


	public String getQuestiontext() {
		return questiontext;
	}


	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}


	public Boolean getIsvalid() {
		return isvalid;
	}


	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public Answer getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", questionorder=" + questionorder + ", questiontext="
				+ questiontext + ", isvalid=" + isvalid + ", answers=" + answers + ", correctAnswer=" + correctAnswer
				+ ", quiz=" + quiz + ", getIdQuestion()=" + getIdQuestion() + ", getQuestionorder()="
				+ getQuestionorder() + ", getQuestiontext()=" + getQuestiontext() + ", getIsvalid()=" + getIsvalid()
				+ ", getAnswers()=" + getAnswers() + ", getCorrectAnswer()=" + getCorrectAnswer() + ", getQuiz()="
				+ getQuiz() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(answers, correctAnswer, idQuestion, isvalid, questionorder, questiontext, quiz);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(answers, other.answers) && Objects.equals(correctAnswer, other.correctAnswer)
				&& idQuestion == other.idQuestion && Objects.equals(isvalid, other.isvalid)
				&& Objects.equals(questionorder, other.questionorder)
				&& Objects.equals(questiontext, other.questiontext) && Objects.equals(quiz, other.quiz);
	}


	public Question(int idQuestion, Integer questionorder,
			@Size(min = 2, max = 1500, message = "The question should be between 2 and 1500 characters") @NotBlank(message = "Question text not provided") String questiontext,
			Boolean isvalid, List<Answer> answers, Answer correctAnswer, Quiz quiz) {
		super();
		this.idQuestion = idQuestion;
		this.questionorder = questionorder;
		this.questiontext = questiontext;
		this.isvalid = isvalid;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.quiz = quiz;
	}


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


//	@ManyToOne
//	private TrainingSession trainingSession;

	
	
	


}
