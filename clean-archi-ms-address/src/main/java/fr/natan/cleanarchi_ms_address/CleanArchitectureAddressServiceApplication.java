package fr.natan.cleanarchi_ms_address;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleanArchitectureAddressServiceApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(
				CleanArchitectureAddressServiceApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
