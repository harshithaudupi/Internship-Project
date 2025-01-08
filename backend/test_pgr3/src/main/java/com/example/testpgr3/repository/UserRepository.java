package com.example.testpgr3.repository;


import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.testpgr3.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	 Optional<User> findByUsername(String username);
      	
	
}




//User findByEmail(String email);
//
//	    @Override
//	    void delete(User user);



//User saveUser(User user);
//
//List<User> getAllUsers();
//
//User getUserById(long id);
//
//User updateUser(User user, long id);