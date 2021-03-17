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
	@Slf4j
	static
	class ChachkieConsumer {

		@EventListener
		void on(ChachkieEmitter.ChachkieFulfiled event) {
			log.info("Fulfiled {}", event.getSource());
		}
	}

	@Component
	@AllArgsConstructor
	static
	class ChachkieEmitter {
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
	static
	class Chachkie {
		Double longitude, latitude;
		Instant when;
	}
}
