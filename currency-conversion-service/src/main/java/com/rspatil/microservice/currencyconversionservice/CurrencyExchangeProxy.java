package com.rspatil.microservice.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="currency-exchange",url="localhost:8000/currency-exchange") //typically name of application we want to connect
@FeignClient(name = "currency-exchange")  //get the url from name server
public interface CurrencyExchangeProxy {


	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to);
	
}
