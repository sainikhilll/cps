package com.revature.cpsrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "owner")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "licence_number")
	private String licenceNumber;

	@Column(name = "licence_url")
	private String licenceUrl;

	@Column(name = "aadhar_number")
	private String aadharNumber;

	@Column(name = "aadhar_url")
	private String aadharUrl;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

//	@ManyToOne
//	@JoinColumn(name = "owner_preference_id")
//	private OwnerPreference ownerPreference;
	
	public Owner() {}
	
	public int getId() {
		return id;
	}

	public Owner(int id, String name, String address, String mobile, String licenceNumber, String licenceUrl,
		String aadharNumber, String aadharUrl, String status, User user ) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.mobile = mobile;
	this.licenceNumber = licenceNumber;
	this.licenceUrl = licenceUrl;
	this.aadharNumber = aadharNumber;
	this.aadharUrl = aadharUrl;
	this.status = status;
	this.user = user;
//	this.ownerPreference = ownerPreference;
}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getLicenceUrl() {
		return licenceUrl;
	}

	public void setLicenceUrl(String licenceUrl) {
		this.licenceUrl = licenceUrl;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAadharUrl() {
		return aadharUrl;
	}

	public void setAadharUrl(String aadharUrl) {
		this.aadharUrl = aadharUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public OwnerPreference getOwnerPreference() {
//		return ownerPreference;
//	}
//
//	public void setOwnerPreference(OwnerPreference ownerPreference) {
//		this.ownerPreference = ownerPreference;
//	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", licenceNumber="
				+ licenceNumber + ", licenceUrl=" + licenceUrl + ", aadharNumber=" + aadharNumber + ", aadharUrl="
				+ aadharUrl + ", status=" + status + ", user=" + user +"]";
	}

    
	

}


