package beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SearchOut {
	private String profileId;
	private BigDecimal height;
	private Integer weight;
	private String hairColor;
	private String city;
	private String state;
	private Timestamp dateOfLastAct;
	private Integer rating;
	private String hobbies;
	
	public SearchOut() {
	}
	public SearchOut(String profileId, BigDecimal height, Integer weight, String hairColor, String city,
			String state, Timestamp dateOfLastAct, Integer rating) {
		this.profileId = profileId;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.city = city;
		this.state = state;
		this.dateOfLastAct = dateOfLastAct;
		this.rating = rating;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Timestamp getDateOfLastAct() {
		return dateOfLastAct;
	}
	public void setDateOfLastAct(Timestamp dateOfLastAct) {
		this.dateOfLastAct = dateOfLastAct;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
}
