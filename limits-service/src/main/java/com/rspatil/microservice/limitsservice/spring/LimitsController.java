package com.rspatil.microservice.limitsservice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rspatil.microservice.limitsservice.bean.Limits;
import com.rspatil.microservice.limitsservice.configuration.LimitsConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	LimitsConfiguration limitsConfiguration;
	
	@GetMapping("/limits")
	public Limits getLimits()
	{
		return new Limits(limitsConfiguration.getMinimum(),limitsConfiguration.getMaximum());
	}
}
