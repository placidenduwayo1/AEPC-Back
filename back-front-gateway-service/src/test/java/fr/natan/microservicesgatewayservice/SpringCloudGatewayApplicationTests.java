package fr.natan.microservicesgatewayservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringCloudGatewayApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(this.getClass().getSimpleName());
	}

}
