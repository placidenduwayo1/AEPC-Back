package fr.natan.microservicesregistryservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MicroservicesRegistryServiceApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
