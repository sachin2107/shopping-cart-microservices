package com.microservices.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.usermanagement.model.User;
import com.microservices.usermanagement.repository.UserManagementRepository;

@Service
public class UserManagementService {

	@Autowired
	private UserManagementRepository userRepository;
	
	public User retrieveUser( User user ) {
		User retrievedUser = this.userRepository.findById( user.getUserId() ).get(); 
		return retrievedUser;
	}
}
