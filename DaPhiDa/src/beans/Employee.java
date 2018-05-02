package beans;

import java.sql.Date;

public class Employee implements java.io.Serializable {
	private String ssn;
	private String role;
	private Date startDate;
	private Integer hourlyRate;
	
	public Employee() {
		
	}
	public Employee(String ssn, String role, Date startDate, Integer hourlyRate) {
		this.ssn = ssn;
		this.role = role;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
	}
	public String getSSN() {
		return ssn;
	}
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
