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
@Table(name = "owner_preference")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OwnerPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "music")
	private String music;

	@Column(name = "smoking")
	private String smoking;

	@Column(name = "pets_allowed")
	private String petsAllowed;
		 
}


