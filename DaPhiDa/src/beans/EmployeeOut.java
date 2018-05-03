package beans;

import java.sql.Date;

public class EmployeeOut {
	private String firstName;
	private String lastName;
	private String state;
	private Integer zipcode;
	private String email;
	private String telephone;
	private String role;
	private Date startDate;
	
	public EmployeeOut() {
	}

	public EmployeeOut(String firstName, String lastName, String state, Integer zipcode, String email, String telephone,
			String role, Date startDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.startDate = startDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
}
