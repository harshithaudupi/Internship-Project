package com.example.testpgr3.controller;

import java.time.LocalDateTime;
import java.util.List;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testpgr3.entity.Complaint;
import com.example.testpgr3.entity.User;
import com.example.testpgr3.repository.UserRepository;
import com.example.testpgr3.service.ComplaintService;
//import com.example.testpgr3.service.JwtService;
//import com.example.testpgr3.service.UserService;


@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	private ComplaintService complaintService;
	
	private UserRepository userRepository;
	
	
   
	public ComplaintController(ComplaintService complaintService) {
		this.complaintService=complaintService;
	}
	
	
	@PostMapping("/fileAComplaint")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<String> saveComplaint(@RequestBody Complaint complaintreq,Authentication authentication) {

		String username = ((User) authentication.getPrincipal()).getUsername();
	    User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

	    Complaint complaint = new Complaint();
	    complaint.setUser(user);
	    complaint.setComplaintType(complaintreq.getComplaintType());
	    complaint.setComplaintDetails(complaintreq.getComplaintDetails());
	    complaint.setDateOfReg(LocalDateTime.now());
	    complaint.sethSno(complaintreq.gethSno());
	    complaint.setLandmark(complaintreq.getLandmark());
	    complaint.setLocality(complaintreq.getLocality());
	    complaint.setState(complaintreq.getState());
	    complaintService.saveComplaint(complaint);

	    return ResponseEntity.status(HttpStatus.CREATED).body("Complaint registered successfully!");
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