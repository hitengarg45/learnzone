package com.amdocs.learnzone.services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amdocs.learnzone.models.User;
import com.amdocs.learnzone.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dtf.format(now));  
	    
		user.setRegDate(date);
		
	    userRepository.save(user);
	}
}
