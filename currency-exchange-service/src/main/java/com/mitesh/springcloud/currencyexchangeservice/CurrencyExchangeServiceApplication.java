package com.mitesh.springcloud.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import brave.sampler.Sampler;

@SpringBootApplication
//In order this service to register with Eureka Naming Server
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	// To Notify to ZuulApiGateway what all request we wants to intercept, will
	// trace all the request here
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
