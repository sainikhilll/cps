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
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
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
	
	@Column(name = "owner_id")
	private String ownerId;
	
	public OwnerPreference() {}

	public OwnerPreference(int id, String music, String smoking, String petsAllowed,String ownerId) {
		super();
		this.id = id;
		this.music = music;
		this.smoking = smoking;
		this.petsAllowed = petsAllowed;
		this.ownerId = ownerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getPetsAllowed() {
		return petsAllowed;
	}

	public void setPetsAllowed(String petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return "OwnerPreference [id=" + id + ", music=" + music + ", smoking=" + smoking + ", petsAllowed="
				+ petsAllowed + ", ownerId=" + ownerId + "]";
	}

	
}


