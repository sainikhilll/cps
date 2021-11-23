package com.revature.cpsrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.service.AdminService;

@RestController
@RequestMapping("/approvals")
public class AdminController {
@Autowired
private AdminService adminservice;
@GetMapping

public List<Owner> ownerdetails(){

	return adminservice.list();

	}

@GetMapping("/updates/{id}")
public void update(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	
	owner.setStatus("Approved");
	adminservice.update(owner);
}

@GetMapping("/rejects/{id}")
public void reject(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	
	owner.setStatus("Rejected");
	adminservice.update(owner);
}

@GetMapping("/blackList/{id}")
public void blackList(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	owner.setStatus("BlackList");
	owner.getUser().setBlacklisted('Y');
	adminservice.update(owner);
}

@GetMapping("/undoBlackList/{id}")
public void undoBlackList(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	owner.setStatus("Pending");
	owner.getUser().setBlacklisted('N');
	adminservice.update(owner);
}

}
