package com.microservices.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.usermanagement.model.User;
import com.microservices.usermanagement.service.UserManagementService;

@RestController
@RequestMapping("/usermanagement")
public class UserManagementController {

	@Autowired
	private UserManagementService userService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/user")
	public ResponseEntity<User> retrieveUserInfo( User user ) {
		user.setUserId(3L);
		User retrievedUser = userService.retrieveUser(user);
		System.out.println("Username : "+ retrievedUser.getUsername());
		HttpHeaders headers = new HttpHeaders();
		headers.add("myHeader", "Header_1");
		headers.add("server.port", environment.getProperty("local.server.port"));
		return new ResponseEntity<User>(retrievedUser, headers, HttpStatus.OK );
	}
}