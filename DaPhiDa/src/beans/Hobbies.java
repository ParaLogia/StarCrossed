package beans;

public class Hobbies {
	private String hobby;
	private String profileID;
	
	public Hobbies() {
		
	}
	public Hobbies(String hobby, String profileID) {
		this.hobby = hobby;
		this.profileID = profileID;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
}
