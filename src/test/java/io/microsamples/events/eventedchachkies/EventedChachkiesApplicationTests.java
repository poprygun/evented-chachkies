package io.microsamples.events.eventedchachkies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class EventedChachkiesApplicationTests {

	@Test
	void contextLoads(@Autowired EventedChachkiesApplication.ChachkieEmitter chachkieEmitter
	, @Autowired EventedChachkiesApplication.ChachkieConsumer chachkieConsumer) {
		chachkieEmitter.fulfil(new EventedChachkiesApplication.Chachkie(0.1,0.2, Instant.now()));

		assertThat()
	}

}
