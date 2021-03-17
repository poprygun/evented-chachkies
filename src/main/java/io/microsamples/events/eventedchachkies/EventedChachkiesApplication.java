package io.microsamples.events.eventedchachkies;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@SpringBootApplication
public class EventedChachkiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventedChachkiesApplication.class, args);
	}

	@Component
	@Slf4j
	class ChachkieConsumer {

		@EventListener
		void on(ChachkieFulfiled event) {
			fulfil(event.getChachkie());
		}

		private void fulfil(Chachkie chachkie) {
			log.info("Fulfiled {}", chachkie);
		}

	}

	@Component
	@AllArgsConstructor
	class ChachkieEmitter {
		private final ChachkieRepository repository;

		public void fulfil(Chachkie chachkie) {
			repository.save(chachkie.fulfil());
		}

	}

	@Repository
	interface ChachkieRepository {

		void save(Chachkie fulfil);
	}

	@Value
	class ChachkieFulfiled {
		Chachkie chachkie;
	}

	@Value
	class Chachkie {
		Double longitude, latitude;
		Instant when;

		public Chachkie fulfil() {
			registerEvent(new ChachkieFulfiled(this));
			return this;
		}
	}

}
