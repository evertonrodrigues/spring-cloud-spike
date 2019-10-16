package com.cajalab.consumerservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(ConsumerRepository consumerRepository){
		return arg ->{
			 Stream.of("Foo", "Bar", "Tar").map(name-> new Consumer(name)).forEach(consumerRepository::save);
		};
	}

}
