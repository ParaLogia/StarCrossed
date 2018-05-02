package beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Profile implements java.io.Serializable {
	private String profileID;
	private String ownerSSN;
	private Integer age;
	private Integer datingAgeRangeStart;
	private Integer datingAgeRangeEnd;
	private Integer datingGeoRange;
	private String m_f;
	private BigDecimal height;
	private Integer weight;
	private String hairColor;
	private Timestamp creationDate;
	private Timestamp lastModDate;
	
	public Profile() {
		
	}
	public Profile(String profileID, String ownerSSN, Integer age, Integer datingAgeRangeStart, Integer datingAgeRangeEnd, Integer datingGeoRange, String m_f, BigDecimal height, Integer weight, String hairColor, Timestamp creatoinDate, Timestamp lastModDate) {
		this.profileID = profileID;
		this.ownerSSN = ownerSSN;
		this.age = age;
		this.datingAgeRangeEnd = datingAgeRangeEnd;
		this.datingAgeRangeStart = datingAgeRangeStart;
		this.datingGeoRange = datingGeoRange;
		this.m_f = m_f;
		this.height = height;
		this.weight = weight;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getOwnerSSN() {
		return ownerSSN;
	}
	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDatingAgeRangeStart() {
		return datingAgeRangeStart;
	}
	public void setDatingAgeRangeStart(Integer datingAgeRangeStart) {
		this.datingAgeRangeStart = datingAgeRangeStart;
	}
	public Integer getDatingAgeRangeEnd() {
		return datingAgeRangeEnd;
	}
	public void setDatingAgeRangeEnd(Integer datingAgeRangeEnd) {
		this.datingAgeRangeEnd = datingAgeRangeEnd;
	}
	public Integer getDatingGeoRange() {
		return datingGeoRange;
	}
	public void setDatingGeoRange(Integer datingGeoRange) {
		this.datingGeoRange = datingGeoRange;
	}
	public String getM_f() {
		return m_f;
	}
	public void setM_f(String m_f) {
		this.m_f = m_f;
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
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	
}
