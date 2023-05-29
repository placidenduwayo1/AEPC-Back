package fr.natan.cleanarchi_ms_employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleanArchitectureEmployeesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureEmployeesServiceApplication.class, args);
	}

}
