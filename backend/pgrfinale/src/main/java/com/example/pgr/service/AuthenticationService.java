package com.example.pgr.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pgr.entity.AuthenticationResponse;
import com.example.pgr.entity.Token;
import com.example.pgr.entity.User;
import com.example.pgr.exception.ResourceNotFoundException;
import com.example.pgr.repository.TokenRepository;
import com.example.pgr.repository.UserRepository;

import java.util.List;


@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository,
    		BCryptPasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request) {

        
        if(repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setState(request.getState());
  	    user.setEmail(request.getEmail());
  	    user.setRole(request.getRole());
  	    user.setpNo(request.getpNo());
       
        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful");

    }
    
   public User getUserById(Integer id) {
		
		return repository.findById(id).orElseThrow(()->
		                       new ResourceNotFoundException("User","Id",id));
	}


	
//	public AuthenticationResponse updateUser(User request, long id) {
//		
//		authenticationManager.updateUser(
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                )
//        );
//
//		
//	   User existingUser = repository.findById(id).orElseThrow(
//			   ()->new ResourceNotFoundException("User","Id",id));
//	   
//       existingUser.setFirstName(request.getFirstName());
//       existingUser.setLastName(request.getLastName());
//       existingUser.setUsername(request.getUsername());
//	   existingUser.setState(request.getState());
//	   existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
//	   existingUser.setEmail(request.getEmail());
//	   existingUser.setRole(request.getRole());
//	   existingUser.setpNo(request.getpNo());
//	   User user = repository.findByUsername(request.getUsername()).orElseThrow();
//	   String jwt = jwtService.generateToken(user);
//
//	        revokeAllTokenByUser(user);
//	        saveUserToken(jwt, user);
//
//	        return new AuthenticationResponse(jwt, "User login was successful");
//	   repository.save(existingUser);
//       return existingUser;
//	}
    private void revokeAllTokenByUser(User user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, User user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }
}
