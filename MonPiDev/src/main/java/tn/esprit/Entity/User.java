package tn.esprit.Entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Size(max =21)
	private String userFirstName;
	
	@NotBlank
	@Size(max =21)
	private String userLastName;
	
	@NotBlank
	@Size(max = 51)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 110)
	private String password;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<TrainingSession> ts;
	
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<LikeTs> likets;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<TrainingSession> getTs() {
		return ts;
	}


	public void setTs(List<TrainingSession> ts) {
		this.ts = ts;
	}


	public List<LikeTs> getLikets() {
		return likets;
	}


	public void setLikets(List<LikeTs> likets) {
		this.likets = likets;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, likets, password, ts, userFirstName, userLastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(likets, other.likets)
				&& Objects.equals(password, other.password) && Objects.equals(ts, other.ts)
				&& Objects.equals(userFirstName, other.userFirstName)
				&& Objects.equals(userLastName, other.userLastName);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", email="
				+ email + ", password=" + password + ", ts=" + ts + ", likets=" + likets + ", getId()=" + getId()
				+ ", getUserFirstName()=" + getUserFirstName() + ", getUserLastName()=" + getUserLastName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getTs()=" + getTs()
				+ ", getLikets()=" + getLikets() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}


	public User(int id, @NotBlank @Size(max = 21) String userFirstName, @NotBlank @Size(max = 21) String userLastName,
			@NotBlank @Size(max = 51) @Email String email, @NotBlank @Size(max = 110) String password,
			List<TrainingSession> ts, List<LikeTs> likets) {
		super();
		this.id = id;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.password = password;
		this.ts = ts;
		this.likets = likets;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
