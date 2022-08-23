package tn.esprit.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
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
public class Quiz implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuiz ;
	
	@OneToOne
	@JsonIgnore
	private User createdBy;
	
	@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a name")
	private String name;

	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide a description")
	private String description;
	
	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide the name of the trainer")
	private String trainerSname;

	private String duration ;

	private Boolean isPublished = false;
	
	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide the location")
	private String location ;

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> questions;

	public Quiz(
			@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.") @NotNull(message = "Please provide a name") String name,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide a description") String description,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the name of the trainer") String trainerSname,
			String duration, Boolean isPublished,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the location") String location) {
		super();
		this.name = name;
		this.description = description;
		this.trainerSname = trainerSname;
		this.duration = duration;
		this.isPublished = isPublished;
		this.location = location;
	}

	public Quiz(User createdBy,
			@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.") @NotNull(message = "Please provide a name") String name,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide a description") String description,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the name of the trainer") String trainerSname,
			String duration, Boolean isPublished,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the location") String location,
			List<Question> questions) {
		super();
		this.createdBy = createdBy;
		this.name = name;
		this.description = description;
		this.trainerSname = trainerSname;
		this.duration = duration;
		this.isPublished = isPublished;
		this.location = location;
		this.questions = questions;
	}

	public Integer getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(Integer idQuiz) {
		this.idQuiz = idQuiz;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrainerSname() {
		return trainerSname;
	}

	public void setTrainerSname(String trainerSname) {
		this.trainerSname = trainerSname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Quiz(Integer idQuiz, User createdBy,
			@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.") @NotNull(message = "Please provide a name") String name,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide a description") String description,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the name of the trainer") String trainerSname,
			String duration, Boolean isPublished,
			@Size(max = 500, message = "The description can't be longer than 500 characters.") @NotNull(message = "Please, provide the location") String location,
			List<Question> questions) {
		super();
		this.idQuiz = idQuiz;
		this.createdBy = createdBy;
		this.name = name;
		this.description = description;
		this.trainerSname = trainerSname;
		this.duration = duration;
		this.isPublished = isPublished;
		this.location = location;
		this.questions = questions;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	

	
	
	

}
