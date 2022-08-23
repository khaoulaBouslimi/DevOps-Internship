package tn.esprit.Entity;

import java.util.Objects;

public class Response {
	private Long question;
	private String selectedAnswer;

	public Long getQuestion() {
		return question;
	}

	public void setQuestion(Long question) {
		this.question = question;
	}

	public String getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, selectedAnswer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return Objects.equals(question, other.question) && Objects.equals(selectedAnswer, other.selectedAnswer);
	}

	@Override
	public String toString() {
		return "Response [question=" + question + ", selectedAnswer=" + selectedAnswer + ", getQuestion()="
				+ getQuestion() + ", getSelectedAnswer()=" + getSelectedAnswer() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public Response(Long question, String selectedAnswer) {
		super();
		this.question = question;
		this.selectedAnswer = selectedAnswer;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
