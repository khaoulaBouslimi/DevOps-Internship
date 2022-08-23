package tn.esprit.Entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class TrainingSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTS;
	
	private String title;
	
	//@Temporal(TemporalType.DATE)
	private String dateDebut;
	
	//@Temporal(TemporalType.DATE)
	private String dateFin;
	
	private String dure;
	
	private String localisation;
	
	private String DescriptionOfTS;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "ts", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<LikeTs> likets;

	public int getIdTS() {
		return idTS;
	}

	public void setIdTS(int idTS) {
		this.idTS = idTS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getDescriptionOfTS() {
		return DescriptionOfTS;
	}

	public void setDescriptionOfTS(String descriptionOfTS) {
		DescriptionOfTS = descriptionOfTS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LikeTs> getLikets() {
		return likets;
	}

	public void setLikets(List<LikeTs> likets) {
		this.likets = likets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DescriptionOfTS, dateDebut, dateFin, dure, idTS, likets, localisation, title, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingSession other = (TrainingSession) obj;
		return Objects.equals(DescriptionOfTS, other.DescriptionOfTS) && Objects.equals(dateDebut, other.dateDebut)
				&& Objects.equals(dateFin, other.dateFin) && Objects.equals(dure, other.dure) && idTS == other.idTS
				&& Objects.equals(likets, other.likets) && Objects.equals(localisation, other.localisation)
				&& Objects.equals(title, other.title) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "TrainingSession [idTS=" + idTS + ", title=" + title + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", dure=" + dure + ", localisation=" + localisation + ", DescriptionOfTS=" + DescriptionOfTS
				+ ", user=" + user + ", likets=" + likets + ", getIdTS()=" + getIdTS() + ", getTitle()=" + getTitle()
				+ ", getDateDebut()=" + getDateDebut() + ", getDateFin()=" + getDateFin() + ", getDure()=" + getDure()
				+ ", getLocalisation()=" + getLocalisation() + ", getDescriptionOfTS()=" + getDescriptionOfTS()
				+ ", getUser()=" + getUser() + ", getLikets()=" + getLikets() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public TrainingSession(int idTS, String title, String dateDebut, String dateFin, String dure, String localisation,
			String descriptionOfTS, User user, List<LikeTs> likets) {
		super();
		this.idTS = idTS;
		this.title = title;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dure = dure;
		this.localisation = localisation;
		DescriptionOfTS = descriptionOfTS;
		this.user = user;
		this.likets = likets;
	}

	public TrainingSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@OneToMany(mappedBy = "trainingSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Question> questions;
//	
//	@OneToOne
//	private Certificate certificate;
	
}
