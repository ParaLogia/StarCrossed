package beans;

import java.sql.Timestamp;

public class BlindDate implements java.io.Serializable {
	private String profileA;
	private String profileB;
	private String profileC;
	private Timestamp dateTime;
	
	public BlindDate() {
		
	}
	public BlindDate(String profileA, String profileB, String profileC, Timestamp dateTime) {
		this.profileA = profileA;
		this.profileB = profileB;
		this.profileC = profileC;
		this.dateTime = dateTime;
	}
	public String getProfileA() {
		return profileA;
	}
	public void setProfileA(String profileA) {
		this.profileA = profileA;
	}
	public String getProfileB() {
		return profileB;
	}
	public void setProfileB(String profileB) {
		this.profileB = profileB;
	}
	public String getProfileC() {
		return profileC;
	}
	public void setProfileC(String profileC) {
		this.profileC = profileC;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
