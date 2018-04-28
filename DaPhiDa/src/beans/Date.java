package beans;

import java.sql.Timestamp;

public class Date {
	private String profile1;
	private String profile2;
	private String custRep;
	private Timestamp dateTime;
	private String location;
	private Double bookingFee;
	private String comments;
	private Integer user1Rating;
	private Integer user2Rating;
	
	public Date() {
		
	}
	public Date(String profile1, String profile2, String custRep, Timestamp dateTime, String location, Double bookingFee, String comments, Integer user1Rating, Integer user2Rating) {
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.custRep = custRep;
		this.dateTime = dateTime;
		this.location = location;
		this.bookingFee = bookingFee;
		this.comments = comments;
		this.user1Rating = user1Rating;
		this.user2Rating = user2Rating;
		
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
	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		this.dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getBookingFee() {
		return bookingFee;
	}
	public void setBookingFee(Double bookingFee) {
		this.bookingFee = bookingFee;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getUser1Rating() {
		return user1Rating;
	}
	public void setUser1Rating(Integer user1Rating) {
		this.user1Rating = user1Rating;
	}
	public Integer getUser2Rating() {
		return user2Rating;
	}
	public void setUser2Rating(Integer user2Rating) {
		this.user2Rating = user2Rating;
	}
}
