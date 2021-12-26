package com.sbmicroservices.currencyconversion.currencyexchange.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sbmicroservices.currencyconversion.model.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangePrody {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveCurrencyExchange(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
