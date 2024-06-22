package com.example.testpgr3.controller;
import java.security.NoSuchAlgorithmException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testpgr3.dto.AuthRequest;
//import com.example.testpgr3.dto.AuthRequest;
import com.example.testpgr3.entity.User;
import com.example.testpgr3.service.JwtService;
//import com.example.testpgr3.service.JwtService;
import com.example.testpgr3.service.UserService;





@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
	private UserService userService;
//	private ValidateUser validateUser;
	
	  @Autowired
      private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
    
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping("/loginUser")
	public ResponseEntity<User> loginUser( @RequestBody User user) throws NoSuchAlgorithmException{
		 User user1 =new User();
		 user1.setUserName(user.getUserName());
		 user1.setPassword(user.getPassword());
    	 return new ResponseEntity<User>(userService.saveUser(user1), HttpStatus.CREATED);
	}

	
    @PostMapping("/registerUser")
	public ResponseEntity<User> saveUser( @RequestBody User user){
    	 return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
  
    
//    @GetMapping("/getAllusers")
//    public List<User> getAllUsers(){
//    	return userService.getAllUsers();
//
//    }
  
    
//    @GetMapping("/getUser/{id}")
//    public ResponseEntity<User> getUserByid(@PathVariable("id")long userId){
//    	return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
//    }
    
    
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")long id
    	          ,@RequestBody User user) throws NoSuchAlgorithmException{
    	    return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
    }
    
    
   @GetMapping("/getAllusers")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public List<User> getAllUsers()
   {
		return userService.getAllUsers();
   }
   
   @GetMapping("/getUser/{id}")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   public ResponseEntity<User> getUserByid(@PathVariable("id")long userId){
  	return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
   }
   
   
   @PostMapping("/authenticate")
   public String authenticateAndGetToken(AuthRequest authRequest) {
	   
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
	    if(authentication.isAuthenticated())
	    {
	    	 return jwtService.generateToken(authRequest.getUserName());
	    }
	    else {
	    	throw new UsernameNotFoundException("Invalid User Request !!!");
	    }
	   
  }
   
   
}
