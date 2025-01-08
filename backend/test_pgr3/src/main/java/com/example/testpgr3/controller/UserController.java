package com.example.testpgr3.controller;
import java.util.Collections;

//import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
//import java.security.NoSuchAlgorithmException;
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.testpgr3.entity.AuthenticationResponse;
//import com.example.testpgr3.dto.AuthRequest;
import com.example.testpgr3.entity.User;
import com.example.testpgr3.service.AuthenticationService;
import com.example.testpgr3.service.JwtService;

//import com.example.testpgr3.service.JwtService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@RestController
@RequestMapping("/users")
public class UserController {
    
  
	private final AuthenticationService authService;
    
	private JwtService jwtService;
	public UserController(AuthenticationService authService) {
		   this.authService = authService;
	}
	
	    
	
	@PostMapping("/loginUser")
	@CrossOrigin(origins="http://localhost:3000/")
	public ResponseEntity<?> login(@RequestBody User request) {
	    try {
	        // Authenticate user
	        AuthenticationResponse response = authService.authenticate(request);
	        String accessToken = response.getAccessToken();
	        String refreshToken = response.getRefreshToken();
	        
	        // Return the tokens in the response
	        return ResponseEntity.ok(new AuthenticationResponse(accessToken, refreshToken));
	    } catch (BadCredentialsException ex) {
	        // Handle invalid credentials
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Collections.singletonMap("message", "Invalid username or password"));
	    } catch (Exception ex) {
	        // Handle unexpected server errors
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.singletonMap("message", "An unexpected error occurred. Please try again."));
	    }
	}


	
    @PostMapping("/registerUser")
    @CrossOrigin(origins="http://localhost:3000/")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
            ) {
        return ResponseEntity.ok(authService.register(request));
    }

//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request) {
//        String token = jwtService.getJwtFromRequest(request); // Extract token from request
//
//        if (token != null && jwtService.isValid(token, null)) { // Validate token (no need for UserDetails if only validating token)
//            // Mark the token as logged out
//            jwtService.invalidateToken(token);
//            return ResponseEntity.ok("Successfully logged out");
//        }
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
//    }
    @PostMapping("/refresh_token")
    public ResponseEntity refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return authService.refreshToken(request, response);
    }
}  