package com.example.testpgr3.entity;




import jakarta.persistence.CascadeType;

//import java.util.Set;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="masterComplaint")
public class MasterComplaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="masterComplaintId")
	private long masterComplaintId;

	@Column(name="resolveTime")
	private String resolveTime;

	@Column(name="complaintName")
	private String complaintName;
	
	@OneToOne(mappedBy = "mastercomplaint", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Complaint complaint;
	

	
	

	public long getMasterComplaintId() {
		return masterComplaintId;
	}

	public void setMasterComplaintId(long masterComplaintId) {
		this.masterComplaintId = masterComplaintId;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getComplaintName() {
		return complaintName;
	}

	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}
    
	
}





//@OneToMany(cascade = CascadeType.ALL)
//private Set<Complaint> ob2;

//@OneToOne(cascade = CascadeType.ALL)
//MasterComplaint ob2;

//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "masterlocalityid") 
//private Complaint complaint;





//public Complaint getComplaint() {
//return complaint;
//}
//
//public void setComplaint(Complaint complaint) {
//this.complaint = complaint;
//}
//
//
