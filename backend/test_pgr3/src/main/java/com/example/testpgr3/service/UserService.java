package com.example.testpgr3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.testpgr3.entity.User;
import com.example.testpgr3.exception.ResourceNotFoundException;
import com.example.testpgr3.repository.UserRepository;

@Component
@Service
public class UserService implements UserDetailsService {
    
	    private final UserRepository repository;

	    public UserService(UserRepository repository) {
	        this.repository = repository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        return repository.findByUsername(username)
	                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
	    }

	    public User getUserByUsername(String username) {
	        return repository.findByUsername(username)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	    }

		
}
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	public User saveUser(User user) {
//		
//         return userRepository.save(user);
//			
//	}	 
//		 
//
//
//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}
//
//
//	
//	public User getUserById(long id) {
////		Optional<User> user = userRepository.findById(id);
////		if(user.isPresent()) {
////			return user.get();
////		}
////		else {
////			throw new ResourceNotFoundException("User","Id",id);
////		}
//		
//		return userRepository.findById(id).orElseThrow(()->
//		                       new ResourceNotFoundException("User","Id",id));
//	}
//
//
//	
//	public User updateUser(User user, long id) throws NoSuchAlgorithmException {
//		
//	   // we need to check whether the employee with the given id exists in database or not	
//		
//	   User existingUser = userRepository.findById(id).orElseThrow(
//			   ()->new ResourceNotFoundException("User","Id",id));
//	   
//	   System.out.println(existingUser.getUserId());
//       existingUser.setFirstName(user.getFirstName());
//       existingUser.setLastName(user.getLastName());
//       existingUser.setUserName(user.getUserName());
//	   existingUser.setState(user.getState());
//	   existingUser.setPassword(user.getPassword());
//	   existingUser.setEmail(user.getEmail());
//	   existingUser.setRole(user.getRole());
//	   existingUser.setpNo(user.getpNo());
//	   
//	   //save existing user to DB
//	   userRepository.save(existingUser);
//       return existingUser;
//	}
//
//
//
//	public UserDetails loadUserByUsername1(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//       public UserInfoUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userInfo = userRepository.findByUserName(username);
//	        return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//
//	    }
//
//
//
//}	
