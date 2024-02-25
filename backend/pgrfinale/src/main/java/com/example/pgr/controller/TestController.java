package com.example.pgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pgr.entity.Complaint;
import com.example.pgr.entity.User;
import com.example.pgr.repository.ComplaintRepository;
import com.example.pgr.repository.UserRepository;



@CrossOrigin(origins = "*", maxAge = 2600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@Autowired
	private ComplaintRepository complaintRepository;	

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/USER")
	@PreAuthorize("hasRole('USER') or hasRole('RO') or hasRole('GRO')")
    public List <User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/RO")
	@PreAuthorize("hasRole('RO')")
	public String ROAccess() {
		return "Redresser can redress the grievances.";
	}

	@GetMapping("/GRO")
	@PreAuthorize("hasRole('GRO')")
	public String GROAccess() {
		return "Router.";
	
	}
		
	@GetMapping("/Complaints")
	@PreAuthorize("hasRole('GRO')or hasRole('RO')")
	public List <Complaint> getAllComplaints(){
		return complaintRepository.findAll();
	}
	
	@PostMapping("/AddCom")
	@PreAuthorize("hasRole('USER')")
     Complaint newComplaint(@RequestBody Complaint newComplaint) {
    	return complaintRepository.save(newComplaint);
	}
	
	
	}

