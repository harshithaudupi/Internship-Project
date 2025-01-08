package com.example.testpgr3.service;

import java.util.Date;

import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.testpgr3.entity.User;
import com.example.testpgr3.repository.TokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Service
public class JwtService {
	
	    @Value("${application.security.jwt.secret-key}")
	    private String secretKey;

	    @Value("${application.security.jwt.access-token-expiration}")
	    private long accessTokenExpire;

	    @Value("${application.security.jwt.refresh-token-expiration}")
	    private long refreshTokenExpire;

     
	    private final TokenRepository tokenRepository;

	    public JwtService(TokenRepository tokenRepository) {
	        this.tokenRepository = tokenRepository;
	    }

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }


	    public boolean isValid(String token, UserDetails user) {
	        String username = extractUsername(token);

	        boolean validToken = tokenRepository
	                .findByAccessToken(token)
	                .map(t -> !t.isLoggedOut())
	                .orElse(false);

	        return (username.equals(user.getUsername())) && !isTokenExpired(token) && validToken;
	    }

	    public boolean isValidRefreshToken(String token, User user) {
	        String username = extractUsername(token);

	        boolean validRefreshToken = tokenRepository
	                .findByRefreshToken(token)
	                .map(t -> !t.isLoggedOut())
	                .orElse(false);

	        return (username.equals(user.getUsername())) && !isTokenExpired(token) && validRefreshToken;
	    }

	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
        
	    public void invalidateToken(String token) {
	        tokenRepository.findByAccessToken(token)
	            .ifPresent(t -> {
	                t.setLoggedOut(true); // Mark the token as logged out
	                tokenRepository.save(t); // Save the updated token back to the repository
	            });
	    }
	    
	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
	        Claims claims = extractAllClaims(token);
	        return resolver.apply(claims);
	    }

	  
		private Claims extractAllClaims(String token) {
	           return Jwts
						.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
	        	//  }
	    }
   

	    public String generateAccessToken(User user) {
	        return generateToken(user, accessTokenExpire);
	        
	    }

	    public String generateRefreshToken(User user) {
	        return generateToken(user, refreshTokenExpire );
	    }
	    
	    private String generateToken(User user, long expireTime) {
	        String token = Jwts
	                .builder()
	                .setSubject(user.getUsername())
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + expireTime ))
	                .signWith(getSigninKey())
	                .compact();
//	        System.out.println("Generated JWT Token: " + token);
	        return token;
	    }

	    private SecretKey getSigninKey() {
	    	 return Keys.secretKeyFor(SignatureAlgorithm.HS256);
	    }

		
	 
	    
	
}