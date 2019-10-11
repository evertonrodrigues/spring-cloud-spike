package com.cajalab.customerservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(CustomerRepository customerRepository){
		return arg ->{
			 Stream.of("Foo", "Bar", "Tar").map(name-> new Customer(name)).forEach(customerRepository::save);
		};
	}

}
