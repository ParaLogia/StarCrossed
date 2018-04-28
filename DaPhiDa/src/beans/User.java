package beans;

import java.sql.Timestamp;

public class User {
	private String ssn;
	private String ppp;
	private Integer rating;
	private Timestamp dateOfLastAct;
	
	public User() {
		
	}
	public User(String ssn, String ppp, Integer rating, Timestamp dateOfLastAct) {
		this.ssn = ssn;
		this.ppp = ppp;
		this.rating = rating;
		this.dateOfLastAct = dateOfLastAct;
	}
	public String getSSN() {
		return ssn;
	}
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	public String getPPP() {
		return ppp;
	}
	public void setPPP(String ppp) {
		this.ppp = ppp;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Timestamp getDateOfLastAct() {
		return dateOfLastAct;
	}
	public void setDateOfLastAct(Timestamp dateOfLastAct) {
		this.dateOfLastAct = dateOfLastAct;
	}
}
