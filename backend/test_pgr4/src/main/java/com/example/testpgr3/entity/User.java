package com.example.testpgr3.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.Data;

//@ComponentScan("com.example.postgresql.controller")
@Data
@Entity
@Table(name="user")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
//	@Max(1)
	private long userId;

	@Column(name="userName")
//	@NotBlank(message="User Name is Mandatory !")
//	@Size(min=2, max=20)
	private String userName;

	

	@Column(name="firstName")
//	@NotBlank(message="First Name is Mandatory !")
//	@Size(min=2, max=20)
	private String firstName;

	@Column(name="lastName")
//	@Size(min=2, max=20)
	private String lastName;
	
	@Column(name="password")
//	@NotBlank(message="Password is Mandatory !")
//	@Size(min=2, max=30)
	private String password;

	 
	@Column(name="state")
//	@Size(min=2, max=20)
	private String state;

	@Column(name="email")
//	@Size(min=2, max=20)
	private String email;

	@Column(name="pNo")
//	@Min(10)
	private String pNo;

	@Column(name="role")
//	@NotBlank(message="Role is Mandatory !")
//	@Size(min=2, max=20)
	private String role;
	
	
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private List<Complaint> complaint;
	 



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getpNo() {
		return pNo;
	}


	public void setpNo(String pNo) {
		this.pNo = pNo;
	}


	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUserName() {

//		this.enabled=false;
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}    
	  
//		public void setPassword(String password) throws NoSuchAlgorithmException {
//	        this.password = encode(password);
//	    }
//
//	    private String encode(String password) throws NoSuchAlgorithmException {
//	        MessageDigest md = MessageDigest.getInstance("MD5");
//	        byte[] messageDigest = md.digest(password.getBytes());
//	        BigInteger no = new BigInteger(1, messageDigest);
//	        String hashText = no.toString(16);
//	        while (hashText.length() < 32) {
//	            hashText = "0" + hashText;
//	        }
//	        return hashText;
//	    }
    
	
//	public User(String userName, String password) {
//	    this.userName = userName;
//	    this.password = password;
//	}


	
//	 private boolean isUsing2FA;
//
//	public boolean isUsing2FA() {
//		return isUsing2FA;
//	}
//
//
//	public void setUsing2FA(boolean isUsing2FA) {
//		this.isUsing2FA = isUsing2FA;
//	}
	
	
//	private boolean enabled;
	
	
	
//	   private String secret;
//
//	 @OneToMany(cascade = CascadeType.ALL)
//	 private Set<Complaint> ob;
//
//	

	
//    public void setEnabled(final boolean enabled) {
//        this.enabled = enabled;
//    }
//    
    
  

//
//    public String getSecret() {
//        return secret;
//    }
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }










//import org.springframework.context.annotation.ComponentScan;

//public Complaint getComplaint() {
//	return complaint;
//}
//
//
//public void setComplaint(Complaint complaint) {
//	this.complaint = complaint;
//}

//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "complaintid")
//private Complaint complaint;