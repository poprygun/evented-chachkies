package io.microsamples.events.eventedchachkies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties="spring.main.lazy-initialization=true")
class EventedChachkiesApplicationTests {

    @MockBean
    private EventedChachkiesApplication.Fulfiler fulfiler;

	@Test
	void contextLoads(@Autowired EventedChachkiesApplication.ChachkieEmitter chachkieEmitter) {
        final EventedChachkiesApplication.Chachkie chachkie = new EventedChachkiesApplication.Chachkie(0.1, 0.2, Instant.now());
        chachkieEmitter.fulfil(chachkie);

		verify(fulfiler, times(1)).fulfil(eq(chachkie));
	}
}
