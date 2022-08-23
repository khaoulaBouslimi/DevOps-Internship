package tn.esprit.Entity;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Rating {

	private float stars;

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stars);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return Float.floatToIntBits(stars) == Float.floatToIntBits(other.stars);
	}

	@Override
	public String toString() {
		return "Rating [stars=" + stars + ", getStars()=" + getStars() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	public Rating(float stars) {
		super();
		this.stars = stars;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
