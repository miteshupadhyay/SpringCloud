# To check limits-service locally
http://localhost:8080/limits

#To check limits-service after connecting to spring-cloud-config-server
http://localhost:8888/limits-service/default

#To check limits-service after connecting to spring-cloud-config-server for QA profile
http://localhost:8888/limits-service/qa

#If we want limits-service to pick values from spring-cloud-config-server, then application.proeprties should be renamed to bootstrap.properties
