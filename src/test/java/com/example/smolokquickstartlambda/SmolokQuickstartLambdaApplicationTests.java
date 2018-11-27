package com.example.smolokquickstartlambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@FunctionalSpringBootTest
@AutoConfigureWebTestClient
@EnableAutoConfiguration
public class SmolokQuickstartLambdaApplicationTests {

	@Autowired
	private WebTestClient client;

	@Test
	public void words() throws Exception {
		client.post().uri("/").body(Mono.just("foo"), String.class).exchange()
				.expectStatus().isOk().expectBody(List.class).isEqualTo(Arrays.asList("FOO"));
	}

}
