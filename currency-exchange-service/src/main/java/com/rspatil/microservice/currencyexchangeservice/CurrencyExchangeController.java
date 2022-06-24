package com.rspatil.microservice.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to)
	{
//		CurrencyExchange currencyExchange =  new CurrencyExchange(1000L, from, to , BigDecimal.valueOf(50));
		
		CurrencyExchange currencyExchange= repository.findByFromAndTo(from, to);
		if(currencyExchange == null)
			throw new RuntimeException("Unable find from "+from+" to "+to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));		
				
		return currencyExchange;
	}
	
	@GetMapping("/test")
	public List<CurrencyExchange> getAllCurrency()
	{
		return repository.findAll();
	}
	
}
