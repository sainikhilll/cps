package com.revature.cpsrest.model;

import java.util.Date;

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
@Table(name = "trip")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Trip {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   @Column(name = "id")
   private int id;
   
   @Column(name = "origin")
   private String origin;
   
   @Column(name = "destination")
   private String destination;
   
   @Column(name = "departure_time")
   private String departureTime;
   
   @Column(name = "price")
   private double price;
   
   @Column(name = "date")
   private Date date;
   
   @Column(name = "number_of_passengers")
   private int numberOfPassengers;
   
   @Column(name = "number_of_seats_available")
   private int numberOfSeatsAvailable;
   
   @Column(name = "car_type")
   private String carType;
   
   @ManyToOne 
   @JoinColumn(name="owner_id")
   private Owner owner;
   
  
}