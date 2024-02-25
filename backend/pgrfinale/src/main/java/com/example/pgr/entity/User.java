package com.example.pgr.entity;

import java.util.Collection;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;





import jakarta.persistence.*;
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
    @Column(name = "id")
    private Integer id;




	@Column(name="username")
//	@NotBlank(message="User Name is Mandatory !")
//	@Size(min=2, max=20)
	private String username;

	

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

	 @Enumerated(value = EnumType.STRING)
	 private Role role;
	
	
	 @OneToMany(mappedBy = "user")
	 private List<Token> tokens;

	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private List<Complaint> complaint;
	 
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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

	    public String getUsername() {
	        return username;
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

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return List.of(new SimpleGrantedAuthority(role.name()));
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
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

		public String getpNo() {
			return pNo;
		}

		public void setpNo(String pNo) {
			this.pNo = pNo;
		}

		public List<Complaint> getComplaint() {
			return complaint;
		}

		public void setComplaint(List<Complaint> complaint) {
			this.complaint = complaint;
		}


}  