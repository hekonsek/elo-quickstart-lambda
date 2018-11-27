package com.example.smolokquickstartlambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class SmolokQuickstartLambdaApplication {

	@Bean
	public Function<Flux<String>, Flux<String>> uppercase() {
		return flux -> flux.map(String::toUpperCase);
	}

	public static void main(String[] args) {
		SpringApplication.run(SmolokQuickstartLambdaApplication.class, args);
	}
}
