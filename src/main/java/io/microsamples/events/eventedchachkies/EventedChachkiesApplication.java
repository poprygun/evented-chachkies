package io.microsamples.events.eventedchachkies;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@SpringBootApplication
public class EventedChachkiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventedChachkiesApplication.class, args);
	}

	@Component
	@AllArgsConstructor
	static class ChachkieConsumer {
		private final Fulfiler fulfiler;

		@EventListener
		void on(ChachkieEmitter.ChachkieFulfiled event) {
			fulfiler.fulfil((Chachkie) event.getSource());
		}
	}

	@Component
	@Slf4j
	static class Fulfiler {
		void fulfil(Chachkie chachkie){
			log.info("Fulfiled {}", chachkie);
		}
	}
	@Component
	@AllArgsConstructor
	static class ChachkieEmitter {
		private final ApplicationEventPublisher publisher;

		public void fulfil(Chachkie chachkie) {
			publisher.publishEvent(new ChachkieFulfiled(chachkie));
		}

		@EqualsAndHashCode(callSuper = false)
		class ChachkieFulfiled extends ApplicationEvent {

			public ChachkieFulfiled(Object source) {
				super(source);
			}
		}
	}

	@Value
	static class Chachkie {
		Double longitude, latitude;
		Instant when;
	}
}
