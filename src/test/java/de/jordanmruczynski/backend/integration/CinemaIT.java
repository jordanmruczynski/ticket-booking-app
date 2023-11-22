package de.jordanmruczynski.backend.integration;

import com.github.javafaker.Faker;
import de.jordanmruczynski.backend.AbstractContainers;
import de.jordanmruczynski.backend.model.dto.ReservationRequest;
import de.jordanmruczynski.backend.model.dto.TicketRequest;
import de.jordanmruczynski.backend.model.ticketshandler.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CinemaIT {

    @Autowired
    private WebTestClient webTestClient;
    private static final String URI = "api/v1/multiplex";
    @Test
    void canMakeReservation() {
        // Create reservation request
        String name = "Jordan";
        String surname = "Mruczyński";
        int screeningId = 4;
        List<TicketRequest> tickets = List.of(
                new TicketRequest(1, TicketType.ADULT),
                new TicketRequest(2, TicketType.CHILD)
        );

        ReservationRequest reservationRequest = new ReservationRequest(name, surname, screeningId, tickets);
        // Send a post request
        webTestClient.post()
                .uri(URI + "/reservations")
                .bodyValue(reservationRequest)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void canGetMovies() {
        webTestClient.get()
                .uri(URI + "/movies?start=2021-06-01T00:00:00&end=2021-06-30T00:00:00")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void canGetScreeningsRoomSeats() {
        webTestClient.get()
                .uri(URI + "/screenings/1/seats")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
