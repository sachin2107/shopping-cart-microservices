package com.sbmicroservices.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbmicroservices.limits.config.Configuration;
import com.sbmicroservices.limits.model.Limit;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/hardcoded-limits")
	public Limit retrieveLimits() {
		return new Limit("xx","zz");
	}
	
	@GetMapping("/limits")
	public Limit retrieveLimitsConfig() {
		return new Limit(config.getMinimum(),config.getMaximum());
	}
}
