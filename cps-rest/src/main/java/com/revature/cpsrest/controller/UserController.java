package com.revature.cpsrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@GetMapping("/register")
	public String test() {
		System.out.println("Test success");
		return "test success";
	}
	
}


	
