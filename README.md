#Backend: spring boot application

- spring boot application, to manage employees, addresses and project related to each employee and companies for which projects are destined.
- the backend application uses microservice orientend architecture, each microservice is implemented into clean architecture pattern

- framework spring boot
- microservices-base application:

	- ***clean-archi-ms-address***
	- ***clean-archi-ms-employee***
	- ***clean-archi-ms-project***
	- ***clean-archi-ms-company***
	
- application microservices communicate each other (1); management of alternative scenarios and resilience (2)
	- (1) **spring cloud openfeign**
	- (2) spring cloud circuit breaker:**Resilience4J**

- design pattern dev for each business microservice: **clean architecture**
- each service get its configuration properties from a spring cloud configuration server: ***ms-config-service***
- back and front communicate using a spring cloud gateway: **spring gateway**
- a spring cloud eureka server for services registration: ***ms-registration-service***

# Dockerization

- each service is containerized using **Docker Engine** and all application services are deployed using a **docker compose**
- a web ui **Portainer** is used to track and follow docker containers
    
Here is a docker compose of deployment all docker images of application [docker-compose](https://github.com/placidenduwayo1/fullstack-application-springboot-angular-deployment.git)
   

# Back and front architecture: 
![spring-cloud-microservices-config-server-2](https://github.com/placidenduwayo1/AEPC-Back/assets/124048212/386f76ee-1de2-4224-8ca9-9521c70a989d)
