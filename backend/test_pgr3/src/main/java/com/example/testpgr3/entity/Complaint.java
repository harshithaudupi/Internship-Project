package com.example.testpgr3.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@Column(name="complaintType", nullable = false)
	private String complaintType;

	@Column(name="complaintDetails",nullable = false)
	private String complaintDetails;

	@Column(name="dateOfReg",nullable = false)
	private LocalDateTime dateOfReg;

	@Column(name="hSno",nullable = false)
	private String hSno ;

	@Column(name="landmark",nullable = false)
	private String landmark;

	@Column(name="locality",nullable = false)
	private String locality;
	
	@Column(name="state",nullable = false)
	private String state;
	
//	@JoinColumn(name = "stateId") 
//	private Complaint complaint;
//	
	 @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "userId", nullable = false)
     private User user;
	
     
	 @OneToOne
	 @JoinColumn(name="lIdFkey")
	 private MasterLocality masterlocality;
	 
	 @OneToOne
	 @JoinColumn(name="cIdFkey")
	 private MasterComplaint mastercomplaint;

	@OneToOne(mappedBy = "complaint")
	private ComplaintState complaintState;
	
	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
	
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


	public LocalDateTime getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDateTime dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public MasterLocality getMasterlocality() {
		return masterlocality;
	}

	public void setMasterlocality(MasterLocality masterlocality) {
		this.masterlocality = masterlocality;
	}

	public MasterComplaint getMastercomplaint() {
		return mastercomplaint;
	}

	public void setMastercomplaint(MasterComplaint mastercomplaint) {
		this.mastercomplaint = mastercomplaint;
	}

	public ComplaintState getComplaintState() {
		return complaintState;
	}

	public void setComplaintState(ComplaintState complaintState) {
		this.complaintState = complaintState;
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
}	