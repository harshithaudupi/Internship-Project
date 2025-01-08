package com.example.testpgr3.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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


@Data
@Entity
@Table(name="user")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
//	@Max(1)
	private long userId;

	@Column(name="username",nullable = false)
//	@NotBlank(message="User Name is Mandatory !")
//	@Size(min=2, max=20)
	private String username;

	

	@Column(name="firstName",nullable = false)
//	@NotBlank(message="First Name is Mandatory !")
//	@Size(min=2, max=20)
	private String firstName;

	@Column(name="lastName",nullable = false)
//	@Size(min=2, max=20)
	private String lastName;
	
	@Column(name="password",nullable = false)
//	@NotBlank(message="Password is Mandatory !")
//	@Size(min=2, max=30)
	private String password;

	 
	@Column(name="state",nullable = false)
//	@Size(min=2, max=20)
	private String state;

	@Column(name="email", nullable = false, unique = true)
	private String email;

	@Column(name="pNo",nullable = false)
//	@Min(10)
	private String pNo;


	@Enumerated(value = EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

	
	
	
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


	


	public String getUsername() {
	        return username;
	}
	
    public void setUsername(String username) {
	        this.username = username;
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
	 @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	  
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return List.of(new SimpleGrantedAuthority(role.name()));
	    }

	   
	    public Role getRole() {
	        return role;
	    }

	    public void setRole(Role role) {
	        this.role = role;
	    }

	    public List<Token> getTokens() {
	        return tokens;
	    }

	    public void setTokens(List<Token> tokens) {
	        this.tokens = tokens;
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