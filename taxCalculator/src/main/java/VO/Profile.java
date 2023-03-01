package VO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Profile {
	

	
	private Long profileId;
	private String fullName;
	private String email;
	private String contact;
	private String password;
	private String role;
	private String plan;
	private String panNumber;
	private Date startDate;
	private Date endDate;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(Long profileId, String fullName, String email, String contact, String password, String role,
			String plan, String panNumber, Date startDate, Date endDate) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.role = role;
		this.plan = plan;
		this.panNumber = panNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", fullName=" + fullName + ", email=" + email + ", contact="
				+ contact + ", password=" + password + ", role=" + role + ", plan=" + plan + ", panNumber=" + panNumber
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	

}
