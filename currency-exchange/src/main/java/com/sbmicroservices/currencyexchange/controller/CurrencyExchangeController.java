package com.sbmicroservices.currencyexchange.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sbmicroservices.currencyexchange.model.CurrencyExchangeBean;

@RestController
public class CurrencyExchangeController {

	private static List<CurrencyExchangeBean> currencyExchangeConfigList = new ArrayList<>();
	
	@Autowired
	private ConfigurableEnvironment cfgEnv;
	
	@EventListener(ApplicationReadyEvent.class)
	public void createCurrencyExchangeConfigList() {
		currencyExchangeConfigList.add(new CurrencyExchangeBean(1L, "USD", "INR", BigDecimal.valueOf(70.1)));
		currencyExchangeConfigList.add(new CurrencyExchangeBean(1L, "USD", "EUR", BigDecimal.valueOf(30.33)));
		currencyExchangeConfigList.add(new CurrencyExchangeBean(1L, "INR", "YEN", BigDecimal.valueOf(10.56)));
		currencyExchangeConfigList.add(new CurrencyExchangeBean(1L, "JPY", "GBP", BigDecimal.valueOf(90.3)));
	}
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean retrieveCurrencyExchange(@PathVariable("from")String from, @PathVariable("to")String to) {
		CurrencyExchangeBean currencyExchangeBean = getCurrencyExchangeValue(from,to);
		currencyExchangeBean.setServerPort(cfgEnv.getProperty("server.port"));
		return currencyExchangeBean;
	}
	
	public CurrencyExchangeBean getCurrencyExchangeValue(String from, String to) {
		List<CurrencyExchangeBean> collect = currencyExchangeConfigList.stream().filter(p -> p.getFrom().equals(from) && p.getTo().equals(to)).collect(Collectors.toList());
		return collect.get(0);
	}
	
}
