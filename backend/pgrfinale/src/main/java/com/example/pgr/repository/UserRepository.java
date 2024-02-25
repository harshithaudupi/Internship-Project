package com.example.pgr.repository;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.pgr.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {


	Optional<User> findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	Optional<User> findById(Integer id);
      	
	
}



