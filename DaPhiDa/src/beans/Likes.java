package beans;

import java.sql.Timestamp;

public class Likes implements java.io.Serializable {
	private String liker;
	private String likee;
	private Timestamp dateTime;
	
	public Likes() {
		
	}
	public Likes(String liker, String likee, Timestamp dateTime) {
		this.liker = liker;
		this.likee = likee;
		this.dateTime = dateTime;
	}
	public String getLiker() {
		return liker;
	}
	public void setLiker(String liker) {
		this.liker = liker;
	}
	public String getLikee() {
		return likee;
	}
	public void setLikee(String likee) {
		this.likee = likee;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
