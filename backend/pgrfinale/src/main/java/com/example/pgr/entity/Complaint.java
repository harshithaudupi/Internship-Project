package com.example.pgr.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="complaint")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaintId")
	private Integer id;

	@Column(name="complaintType")
	private String complaintType;

	@Column(name="complaintDetails")
	private String complaintDetails;

	@Column(name="dateOfReg")
	@JsonFormat(pattern="yyyy-MM-dd")
//	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfReg ;

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
	
	
   
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Date getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(Date dateOfReg) {
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
	public Complaint() {

	}

	public Complaint(Integer id,String type, String details, Date date, String hSNo, String landmark, String locality, String hSno) {
		super();
		this.id = id;
		this.complaintType = type;
		this.complaintDetails = details;
		this.dateOfReg = date;
		this.hSno=hSno;
		this.landmark = landmark;
		this.locality = locality;
	}
}
	
