package com.example.testpgr3.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testpgr3.entity.Complaint;
import com.example.testpgr3.service.ComplaintService;


@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	private ComplaintService complaintService;
	

	public ComplaintController(ComplaintService complaintService) {
		this.complaintService=complaintService;
	}
	
	@PostMapping("/fileAComplaint")
	public ResponseEntity <Complaint> saveComplaint(@RequestBody Complaint complaint){
		return new ResponseEntity <Complaint> (complaintService.saveComplaint(complaint),HttpStatus.CREATED);
	}

	
	 @GetMapping("/viewAllComplaints")
	 public List<Complaint> getAllComplaints(){
	    	return complaintService.getAllComplaints();
	    	
	 }
	 
	 @GetMapping("/searchAComplaint/{id}")
     public ResponseEntity<Complaint> getComplaintByid(@PathVariable("id")long complaintId){
	    	return new ResponseEntity<Complaint>(complaintService.getComplaintById(complaintId),HttpStatus.OK);
	    }
	    
	 
	 @PutMapping("/updateComplaint/{id}")
	 public ResponseEntity<Complaint> updateComplaint(@PathVariable("id")long id
	    	          ,@RequestBody Complaint complaint){
	    	    return new ResponseEntity<Complaint>(complaintService.updateComplaint(complaint, id),HttpStatus.OK);
	    }


}	

