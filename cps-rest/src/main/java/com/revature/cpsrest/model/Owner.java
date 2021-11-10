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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

	@ManyToOne
	@JoinColumn(name = "owner_preference_id")
	private OwnerPreference ownerPreference;
	
	

}


