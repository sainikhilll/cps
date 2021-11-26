package com.revature.cpsrest.dto;

import java.sql.Date;

import com.revature.cpsrest.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PassengerDto {
	
	private int id;
	private String name;
	private String mobileNumber;
	private Date dateOfBirth;
	private User user;
}
