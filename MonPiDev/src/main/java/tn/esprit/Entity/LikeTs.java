package tn.esprit.Entity;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import tn.esprit.Entity.*;




@Data
@Entity
public class LikeTs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Like_id;
	

	private boolean isLiked;
	
	@Enumerated(EnumType.STRING)
	private InteractionTs interactionType;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnore
	private User user;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idTS")
	@JsonIgnore
	private TrainingSession ts ;




	public int getLike_id() {
		return Like_id;
	}




	public void setLike_id(int like_id) {
		Like_id = like_id;
	}




	public boolean isLiked() {
		return isLiked;
	}




	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}




	public InteractionTs getInteractionType() {
		return interactionType;
	}




	public void setInteractionType(InteractionTs interactionType) {
		this.interactionType = interactionType;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public TrainingSession getTs() {
		return ts;
	}




	public void setTs(TrainingSession ts) {
		this.ts = ts;
	}




	@Override
	public int hashCode() {
		return Objects.hash(Like_id, interactionType, isLiked, ts, user);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LikeTs other = (LikeTs) obj;
		return Like_id == other.Like_id && interactionType == other.interactionType && isLiked == other.isLiked
				&& Objects.equals(ts, other.ts) && Objects.equals(user, other.user);
	}




	@Override
	public String toString() {
		return "LikeTs [Like_id=" + Like_id + ", isLiked=" + isLiked + ", interactionType=" + interactionType
				+ ", user=" + user + ", ts=" + ts + ", getLike_id()=" + getLike_id() + ", isLiked()=" + isLiked()
				+ ", getInteractionType()=" + getInteractionType() + ", getUser()=" + getUser() + ", getTs()=" + getTs()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}




	public LikeTs(int like_id, boolean isLiked, InteractionTs interactionType, User user, TrainingSession ts) {
		super();
		Like_id = like_id;
		this.isLiked = isLiked;
		this.interactionType = interactionType;
		this.user = user;
		this.ts = ts;
	}




	public LikeTs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
