package com.rspatil.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>
{
	//all basic are pre implemented, we can add some more here in specific format so the jpa will implement them
	public CurrencyExchange findByFromAndTo(String from, String to);

}
