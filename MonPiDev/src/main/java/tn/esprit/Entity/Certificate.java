package tn.esprit.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Certificate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCertificate;
	
	private String description;
	
	private Date duree ;
	
	private String Title;

	public int getIdCertificate() {
		return idCertificate;
	}

	public void setIdCertificate(int idCertificate) {
		this.idCertificate = idCertificate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@Override
	public String toString() {
		return "Certificate [idCertificate=" + idCertificate + ", description=" + description + ", duree=" + duree
				+ ", Title=" + Title + ", getIdCertificate()=" + getIdCertificate() + ", getDescription()="
				+ getDescription() + ", getDuree()=" + getDuree() + ", getTitle()=" + getTitle() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(int idCertificate, String description, Date duree, String title) {
		super();
		this.idCertificate = idCertificate;
		this.description = description;
		this.duree = duree;
		Title = title;
	}
	
	
}
