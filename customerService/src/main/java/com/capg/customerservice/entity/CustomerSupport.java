package com.capg.customerservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerSupport")
public class CustomerSupport {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String userEmail;
	private String supportEmail;
	private String status;
	private String mobNo;
	private String query;
	private Date postDate;
	public CustomerSupport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerSupport(Long id, String userEmail, String supportEmail, String status, String mobNo, String query,
			Date postDate) {
		super();
		Id = id;
		this.userEmail = userEmail;
		this.supportEmail = supportEmail;
		this.status = status;
		this.mobNo = mobNo;
		this.query = query;
		this.postDate = postDate;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getSupportEmail() {
		return supportEmail;
	}
	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "CustomerSupport [Id=" + Id + ", userEmail=" + userEmail + ", supportEmail=" + supportEmail + ", status="
				+ status + ", mobNo=" + mobNo + ", query=" + query + ", postDate=" + postDate + "]";
	}
	
	
	
	
}
	
	
