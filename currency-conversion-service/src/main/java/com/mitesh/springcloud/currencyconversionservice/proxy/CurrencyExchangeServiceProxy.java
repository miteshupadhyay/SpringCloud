package com.mitesh.springcloud.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mitesh.springcloud.currencyconversionservice.bean.CurrencyConversionBean;


//To know feign , whom to make a call to consume like 11 line
//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")


@FeignClient(name = "currency-exchange-service")
//Once we used Ribbon like 16 line, we don't need to pass URL in the feign , We will configure the same into App.properties like 14 line
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//Will have to define the method to talk to Currency Exchange Service
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchanegValue(@PathVariable("from") String from,@PathVariable("to") String to);
	
}
