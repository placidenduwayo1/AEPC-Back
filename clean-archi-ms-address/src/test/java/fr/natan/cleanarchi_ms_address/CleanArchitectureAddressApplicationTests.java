package fr.natan.cleanarchi_ms_address;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CleanArchitectureAddressApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(this.getClass().getSimpleName());
	}

}
