package fr.natan.cleanarchi_ms_company;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleanArchitectureCompanyServiceApplication {
	public static void main(String[] args) {
		SpringApplication app =new SpringApplication(
				CleanArchitectureCompanyServiceApplication.class);
				app.setBannerMode(Banner.Mode.OFF);
				app.run(args);
	}

}
