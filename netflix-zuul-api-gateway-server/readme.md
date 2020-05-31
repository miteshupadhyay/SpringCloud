# To send request through Zuul API Gateway instead of directly

eg. http://localhost:8000/currency-exchange/from/USD/to/INR

will be access as 

http://localhost:8765/{service name}/{uri}
http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

Once request will get execute successfully , we will get below logs into console

2020-05-31 06:25:55.716  INFO 4420 --- [nio-8765-exec-9] c.m.s.n.ZuulLoggingFilter : request->org.springframework.cloud.netflix.zuul.filters.pre.Servlet30RequestWrapper@5a7ee50c request uri->/currency-exchange-service/currency-exchange/from/USD/to/INR



