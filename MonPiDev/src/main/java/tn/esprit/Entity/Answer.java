package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class Answer implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idanswer;

	private String answerorder;

	@Size(min = 1, max = 1500, message = "The answer should be less than 1500 characters")
	@NotBlank(message = "No answer text provided.")
	private String answertext;
	
	

	@ManyToOne
	@JsonIgnore
	private Question question;

	

	public Answer(String answerorder) {
		super();
		this.answerorder = answerorder;
	}



	public Answer(String answerorder,
			@Size(min = 1, max = 1500, message = "The answer should be less than 1500 characters") @NotBlank(message = "No answer text provided.") String answertext) {
		super();
		this.answerorder = answerorder;
		this.answertext = answertext;
	}



	public Answer(String answerorder,
			@Size(min = 1, max = 1500, message = "The answer should be less than 1500 characters") @NotBlank(message = "No answer text provided.") String answertext,
			Question question) {
		super();
		this.answerorder = answerorder;
		this.answertext = answertext;
		this.question = question;
	}



	public int getIdanswer() {
		return idanswer;
	}



	public void setIdanswer(int idanswer) {
		this.idanswer = idanswer;
	}



	public String getAnswerorder() {
		return answerorder;
	}



	public void setAnswerorder(String answerorder) {
		this.answerorder = answerorder;
	}



	public String getAnswertext() {
		return answertext;
	}



	public void setAnswertext(String answertext) {
		this.answertext = answertext;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	public Answer(int idanswer, String answerorder,
			@Size(min = 1, max = 1500, message = "The answer should be less than 1500 characters") @NotBlank(message = "No answer text provided.") String answertext,
			Question question) {
		super();
		this.idanswer = idanswer;
		this.answerorder = answerorder;
		this.answertext = answertext;
		this.question = question;
	}



	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		return Objects.hash(answerorder, answertext, idanswer, question);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(answerorder, other.answerorder) && Objects.equals(answertext, other.answertext)
				&& idanswer == other.idanswer && Objects.equals(question, other.question);
	}



	@Override
	public String toString() {
		return "Answer [idanswer=" + idanswer + ", answerorder=" + answerorder + ", answertext=" + answertext
				+ ", question=" + question + ", getIdanswer()=" + getIdanswer() + ", getAnswerorder()="
				+ getAnswerorder() + ", getAnswertext()=" + getAnswertext() + ", getQuestion()=" + getQuestion()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	

	

	
	

}
