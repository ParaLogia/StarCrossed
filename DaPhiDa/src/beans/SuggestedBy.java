package beans;

import java.sql.Timestamp;

public class SuggestedBy {
	private String custRep;
	private String profile1;
	private String profile2;
	private Timestamp dateTime;
	
	public SuggestedBy() {
		
	}
	public SuggestedBy(String custRep, String profile1, String profile2, Timestamp dateTime) {
		this.custRep = custRep;
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.dateTime = dateTime;
	}
	
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	public String getProfile1() {
		return profile1;
	}
	public void setProfile1(String profile1) {
		this.profile1 = profile1;
	}
	public String getProfile2() {
		return profile2;
	}
	public void setprofile2(String profile2) {
		this.profile2 = profile2;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
