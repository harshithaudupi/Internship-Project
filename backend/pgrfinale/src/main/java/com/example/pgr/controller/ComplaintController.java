package com.example.pgr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.pgr.entity.AuthenticationResponse;
import com.example.pgr.entity.Complaint;
import com.example.pgr.repository.ComplaintRepository;
//import com.example.pgr.service.ComplaintService;


@RestController
@CrossOrigin(origins = "*", maxAge = 2600)
@RequestMapping("/complaints")
public class ComplaintController {

	@Autowired
	ComplaintRepository complaintRepository;
//	
//	@Autowired
//    ComplaintService complaintService;
	
	@PostMapping("/fileAComplaint")
	public ResponseEntity <Complaint> saveComplaint(@RequestBody Complaint complaint){
		return new ResponseEntity <Complaint> (complaintRepository.save(complaint),HttpStatus.CREATED);
	}

	
	 @GetMapping("/viewAllComplaints")
	 public List<Complaint> getAllComplaints(){
	    	return complaintRepository.findAll();
	    	
	 }



}
