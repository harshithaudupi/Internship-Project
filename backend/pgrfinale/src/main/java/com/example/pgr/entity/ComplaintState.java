package com.example.pgr.entity;

import jakarta.persistence.CascadeType;
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
@Table(name="complaintState")
public class ComplaintState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaintStateId")
	private long stateComplaintId;
	
	
	@Column(name="stateOC")
	private String stateOC;
	
	@Column(name="dateOfComplaintReg")
	private String dateOfComplaintReg;
	
	@Column(name="resolvedPerson")
	private String resolvedPerson;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stateId") 
	private Complaint complaint;

	
	public String getStateOC() {
		return stateOC;
	}

	public void setStateOC(String stateOC) {
		this.stateOC = stateOC;
	}



	public String getDateOfComplaintReg() {
		return dateOfComplaintReg;
	}

	public void setDateOfComplaintReg(String dateOfComplaintReg) {
		this.dateOfComplaintReg = dateOfComplaintReg;
	}

	public String getResolvedPerson() {
		return resolvedPerson;
	}

	public void setResolvedPerson(String resolvedPerson) {
		this.resolvedPerson = resolvedPerson;
	}

	
}
