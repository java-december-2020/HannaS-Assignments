package com.smithHanna.ControllersAndViews.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.smithHanna.ControllersAndViews.models.User;
import com.smithHanna.ControllersAndViews.repositories.UserRepository;

import java.util.Optional; 

@Service
public class UserService {
	
	private UserRepository uRepo; 
	
	public UserService(UserRepository userRepo) {
		this.uRepo = userRepo; 
	}

	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		Optional<User> u = uRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null; 
		}
	}
	
	public boolean authenticateuser(String email, String password) {
		User user = uRepo.findByEmail(email);
		if(user == null) {
			return false; 
		}else {
		if(BCrypt.checkpw(password, user.getPassword())) {
			return true; 
		}else {
			return false; 
			}
		}
	}
}
