package com.example.pgr.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.pgr.entity.Complaint;
import com.example.pgr.exception.ResourceNotFoundException;
import com.example.pgr.repository.ComplaintRepository;



@Component
@Service
public class ComplaintService{
  

	@Autowired
	private ComplaintRepository complaintRepository;



	
    
	public Complaint saveComplaint(Complaint complaint) {
          return complaintRepository.save(complaint);
	}
	
    
	
	public List<Complaint> getAllComplaints() {
		return complaintRepository.findAll();
	}



	
	public Complaint updateComplaint(Complaint complaint, long id) {
	
	Complaint existingComplaint = complaintRepository.findById(id).orElseThrow(
		   ()->new ResourceNotFoundException("Complaint","Id",id));
		   
	      
	       existingComplaint.setComplaintDetails(complaint.getComplaintDetails());
	       existingComplaint.setDateOfReg(complaint.getDateOfReg());
	       existingComplaint.sethSno(complaint.gethSno());
	       existingComplaint.setLandmark(complaint.getLandmark());
	       existingComplaint.setLocality(complaint.getLocality());
	       existingComplaint.setComplaintType(complaint.getComplaintType());		   
		   //save existing user to DB
		   complaintRepository.save(existingComplaint);
	       return existingComplaint;
	}
	
     
	
	public Complaint getComplaintById(long id) {

		return complaintRepository.findById(id).orElseThrow(()->
		                       new ResourceNotFoundException("Complaint","Id",id));
	}
	


}





