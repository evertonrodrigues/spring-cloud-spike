package com.cajalab.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public DiscoveryClientRouteDefinitionLocator definitionLocator(DiscoveryClient discoveryClient,
			DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}

	// @Bean
	// public RouteLocator routeLocator(RouteLocatorBuilder builder) {
	// 	//@formatter:off
	// 	return builder.routes()
	// 			// load balance customers
	// 			.route("customers-find-all", r -> r.path("/customers")
	// 				.uri("lb://customer-service/customers"))				
	// 			.build();
	// 	//@formatter:on
	// }

}
