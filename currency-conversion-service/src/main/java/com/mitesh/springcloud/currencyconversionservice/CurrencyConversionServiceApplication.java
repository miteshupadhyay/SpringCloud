package com.mitesh.springcloud.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.mitesh.springcloud.currencyconversionservice")
//In order this service to register with Eureka Naming Server
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	// To Notify to ZuulApiGateway what all request we wants to intercept, will
	// trace all the request here
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
