package com.example.testpgr3.entity;

import jakarta.persistence.CascadeType;


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
@Table(name="masterLocality")
public class MasterLocality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="masterLocalityId")
	private long masterLocalityId;

	@Column(name="localityName")
	private String localityName;
	
	@OneToOne(mappedBy = "masterlocality", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Complaint complaint;
	
}





//@OneToMany(cascade = CascadeType.ALL)
//private Set<Complaint> ob1;

//@OneToOne(cascade = CascadeType.ALL)
//Complaint ob1;


//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "localityid") 
//private Complaint complaint;

