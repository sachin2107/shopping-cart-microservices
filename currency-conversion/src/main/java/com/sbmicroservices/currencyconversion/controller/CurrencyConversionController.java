package com.sbmicroservices.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sbmicroservices.currencyconversion.currencyexchange.proxy.CurrencyExchangePrody;
import com.sbmicroservices.currencyconversion.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@Autowired
	private ConfigurableEnvironment cfgEnv;
	
	@Autowired
	private CurrencyExchangePrody proxy;

	@GetMapping("/currency-conversion-hardcoded/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionBean getCurrencyConvertedHardcoded(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("qty") BigDecimal quantity) {
		return new CurrencyConversionBean(1L, "USD", "INR", BigDecimal.valueOf(44.23), BigDecimal.valueOf(10),
				BigDecimal.valueOf(10), cfgEnv.getProperty("server.port"));
	}

	@GetMapping("/currency-conversion-resttemplate/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionBean getCurrencyConverted(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("qty") BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean body = responseEntity.getBody();
		
		return new CurrencyConversionBean(body.getId(), from, to, body.getConversionMultiple(), quantity,
				quantity.multiply(body.getConversionMultiple()), cfgEnv.getProperty("server.port"));
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionBean getCurrencyConvertedFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("qty") BigDecimal quantity) {
		
		CurrencyConversionBean body = proxy.retrieveCurrencyExchange(from, to);
		
		return new CurrencyConversionBean(body.getId(), from, to, body.getConversionMultiple(), quantity,
				quantity.multiply(body.getConversionMultiple()), cfgEnv.getProperty("server.port"));
	}
}
