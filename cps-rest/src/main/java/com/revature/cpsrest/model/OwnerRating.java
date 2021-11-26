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

@Entity(name = "trip")
@Table(name = "owner_rating")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OwnerRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "review")
	private String review;
	
	@ManyToOne
	@JoinColumn(name= "passenger_id")
	private Passenger passenger;
	
	@ManyToOne
	@JoinColumn(name= "owner_id")
	private Owner owner;
}
