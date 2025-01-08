package com.example.testpgr3.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpgr3.entity.Complaint;
import com.example.testpgr3.entity.User;



public interface ComplaintRepository extends JpaRepository<Complaint,Long>{

	List<Complaint> findByUser(User user);
	
	
	
}


//Complaint saveComplaint(Complaint complaint);
//
//	List<Complaint> getAllComplaints();
//	
//	Complaint updateComplaint(Complaint complaint, long id);
//	
//	Complaint getComplaintById(long id);
