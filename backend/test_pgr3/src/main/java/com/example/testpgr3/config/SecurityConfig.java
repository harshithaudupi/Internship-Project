package com.example.testpgr3.config;

///import com.javatechie.filter.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
//import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.testpgr3.filter.JwtAuthFilter;
import com.example.testpgr3.service.UserService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Import(AuthenticationConfiguration.class)
public class SecurityConfig {

	
        private JwtAuthFilter jwtAuthFilter;
      
        private final CustomLogoutHandler logoutHandler;
    
  
	    private UserService userDetailsService;

	    public SecurityConfig(UserService userDetailsService,
	    		              JwtAuthFilter jwtAuthFilter,
	                          CustomLogoutHandler logoutHandler) {
	        this. userDetailsService=  userDetailsService;
	        this.jwtAuthFilter= jwtAuthFilter;
	        this.logoutHandler = logoutHandler;
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        return http
	                .csrf(AbstractHttpConfigurer::disable)
	                .authorizeHttpRequests(
	                        req->req.requestMatchers("/users/**", "/users/refresh_token/**","/complaints/**").permitAll()
	                                .requestMatchers("/admin_only/**").hasAuthority("ADMIN")
	                                .anyRequest()
	                                .authenticated()
	                ).userDetailsService( userDetailsService)
	                .sessionManagement(session->session
	                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
	                .exceptionHandling(
	                        e->e.accessDeniedHandler(
	                                        (request, response, accessDeniedException)->response.setStatus(403)
	                                )
	                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
	                .logout(l->l
	                        .logoutUrl("/logout")
	                        .addLogoutHandler(logoutHandler)
	                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()
	                        ))
	                .build();

	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	        return daoAuthenticationProvider;
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }
}

//.requestMatchers("/complaints/**").authenticated()