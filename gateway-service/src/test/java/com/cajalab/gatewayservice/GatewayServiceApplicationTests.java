package com.cajalab.gatewayservice;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayServiceApplicationTests {

	private WebTestClient webClient;

	@LocalServerPort
	private int port = 0;

	@Before
	public void setup() {
		String baseUrl = "http://localhost:" + port;
		this.webClient = WebTestClient.bindToServer().responseTimeout(Duration.ofSeconds(10)).baseUrl(baseUrl).build();
	}

	@Test
	public void contextLoads() {
		webClient.get().uri("/customers").exchange().expectStatus().isOk();
	}

}
