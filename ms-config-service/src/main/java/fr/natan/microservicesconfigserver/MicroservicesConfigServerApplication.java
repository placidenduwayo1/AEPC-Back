package fr.natan.microservicesconfigserver;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicesConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MicroservicesConfigServerApplication.class);
		app.setBannerMode(Banner.Mode.LOG);
		app.run(args);
	}

}
