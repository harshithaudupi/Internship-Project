package com.example.testpgr3.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;

import com.example.testpgr3.service.JwtService;
import com.example.testpgr3.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Primary
public class JwtAuthFilter extends OncePerRequestFilter{
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userDetailsService;
	
	    public JwtAuthFilter(JwtService jwtService, UserService userDetailsService) {
	        this.jwtService = jwtService;
	        this.userDetailsService = userDetailsService;
	    }

	    @Override
	    protected void doFilterInternal(
	            @NonNull HttpServletRequest request,
	             @NonNull HttpServletResponse response,
	             @NonNull FilterChain filterChain)
	            throws ServletException, IOException {

	        String authHeader = request.getHeader("Authorization");

	        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
	            filterChain.doFilter(request,response);
	            return;
	        }

	        String token = authHeader.substring(7);
	        String username = jwtService.extractUsername(token);

	        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


	            if(jwtService.isValid(token, userDetails)) {
	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities()
	                );

	                authToken.setDetails(
	                        new WebAuthenticationDetailsSource().buildDetails(request)
	                );

	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }
	        filterChain.doFilter(request, response);


	    }
}