package com.example.testpgr3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="complaint")

public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaintId")
	private long complaintId;

	@Column(name="complaintType")
	private String complaintType;

	@Column(name="complaintDetails")
	private String complaintDetails;

	@Column(name="dateOfReg")
	private String dateOfReg ;

	@Column(name="hSno")
	private String hSno ;

	@Column(name="landmark")
	private String landmark;

	@Column(name="locality")
	private String locality;
	
//	@JoinColumn(name = "stateId") 
//	private Complaint complaint;
//	
	 @OneToOne
	 @JoinColumn(name = "ucIdFkey")
	 private User user;
     
	 @OneToOne
	 @JoinColumn(name="lIdFkey")
	 private MasterLocality masterlocality;
	 
	 @OneToOne
	 @JoinColumn(name="cIdFkey")
	 private MasterComplaint mastercomplaint;

	@OneToOne(mappedBy = "complaint")
	private ComplaintState complaintState;
	
	
   
	
	public long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getComplaintDetails() {
		return complaintDetails;
	}

	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}

	public String getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(String dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String gethSno() {
		return hSno;
	}

	public void sethSno(String hSno) {
		this.hSno = hSno;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	//import jakarta.persistence.OneToMany;
	//import jakarta.persistence.ManyToOne;
	
	//import java.util.Set;

	//import org.springframework.context.annotation.ComponentScan;
 
	//@ComponentScan("com.example.postgresql.controller")
	

//	public MasterLocality getMasterLocality() {
//		return masterLocality;
//	}
//
//	public void setMasterLocality(MasterLocality masterLocality) {
//		this.masterLocality = masterLocality;
//	}
//
//	public MasterComplaint getMasterComplaint() {
//		return masterComplaint;
//	}
//
//	public void setMasterComplaint(MasterComplaint masterComplaint) {
//		this.masterComplaint = masterComplaint;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	
	
//	 
//	 @OneToOne
//	 @JoinColumn(name="Id")
//	 private MasterComplaint ob2;
	 
	 
//	@OneToOne(mappedBy = "complaint")
//	private MasterLocality masterLocality;
//	
//	@OneToOne(mappedBy = "complaint")
//	private MasterComplaint masterComplaint;
//	
//	@OneToOne(mappedBy = "complaint")
//	private User user;
//	


}
