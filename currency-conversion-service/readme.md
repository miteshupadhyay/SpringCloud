# To check currency-conversion-service locally
http://localhost:8100/currency-converter/from/USD/to/INR/quantity/50

# To check currency-conversion-service locally using Feign
http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/50

#Once application with communicate to Sleuth , will see below id in the request.

2020-05-31 10:12:44.911  INFO [currency-conversion-service,b5a7882636f70814,b5a7882636f70814,false] 7668 --- [nio-8100-exec-3] c.m.s.c.c.CurrencyConversionController   : com.mitesh.springcloud.currencyconversionservice.bean.CurrencyConversionBean@2f272403

and the same id can be seen into another service as well

Hibernate: select exchangeva0_.id as id1_0_, exchangeva0_.conversion_multiple as conversi2_0_, exchangeva0_.currency_from as currency3_0_, exchangeva0_.port as port4_0_, exchangeva0_.currency_to as currency5_0_ from exchange_value exchangeva0_ where exchangeva0_.currency_from=? and exchangeva0_.currency_to=?
2020-05-31 10:12:44.848  INFO [currency-exchange-service,b5a7882636f70814,d886d88d3d594424,false] 7768 --- [nio-8000-exec-9] c.m.s.c.c.CurrencyExchangeController     : com.mitesh.springcloud.currencyexchangeservice.bean.ExchangeValue@7c09e9c4

#To know the zipkin that Rabbit MQ is running (windows)
SET RABBIT_URI=amqp://localhost


#Zipkin Server details
1) Download the Zipkin-Server jar 
2) java -jar Zipkin server jar
3) localhost:9411/zipkin



