package com.mitesh.springcloud.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mitesh.springcloud.currencyconversionservice.bean.CurrencyConversionBean;
import com.mitesh.springcloud.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	private Logger logger=LoggerFactory.getLogger(CurrencyConversionController.class);
		
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,
				@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables=new HashMap<String, String>();
			uriVariables.put("from",from);
			uriVariables.put("to",to);
			
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class,uriVariables);
		
		
			CurrencyConversionBean conversionBean = responseEntity.getBody();
		return new CurrencyConversionBean(conversionBean.getId(), from, to, conversionBean.getConversionMultiple(),
					quantity, quantity.multiply(conversionBean.getConversionMultiple()),conversionBean.getPort());
	}
	
	
	//Below method uses FeignClients to make call to CurrencyExchangeService
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,
				@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables=new HashMap<String, String>();
			uriVariables.put("from",from);
			uriVariables.put("to",to);
			
			CurrencyConversionBean bean=proxy.retrieveExchanegValue(from, to);
			
			logger.info("{}",bean);
			
			return new CurrencyConversionBean(bean.getId(), from, to, bean.getConversionMultiple(),
					quantity, quantity.multiply(bean.getConversionMultiple()),bean.getPort());
	}
}
