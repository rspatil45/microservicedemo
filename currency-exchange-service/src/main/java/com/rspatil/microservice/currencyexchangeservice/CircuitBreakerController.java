package com.rspatil.microservice.currencyexchangeservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name="default") //by default 3 retry
//	@Retry(name="customretry", fallbackMethod = "hardcodedfallback")
	@CircuitBreaker(name="default", fallbackMethod = "hardcodedfallback")
	public String sampleApi()
	{
		logger.info("sample api call received");
		//calling some non existing service
		ResponseEntity<String> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		return responseEntity.getBody();
	}
	
	public String hardcodedfallback(Exception ex)
	{
		return "fallback-response";
	}
}
