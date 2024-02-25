package com.example.pgr.repository;




//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pgr.entity.Complaint;



public interface ComplaintRepository extends JpaRepository<Complaint,Long>{



//	Optional<Complaint>findById(Integer id);
	
	
	
}


//Complaint saveComplaint(Complaint complaint);
//
//	List<Complaint> getAllComplaints();
//	
//	Complaint updateComplaint(Complaint complaint, long id);
//	
//	Complaint getComplaintById(long id);
