package de.jordanmruczynski.backend.controller;

import de.jordanmruczynski.backend.model.Reservation;
import de.jordanmruczynski.backend.model.dto.ReservationRequest;
import de.jordanmruczynski.backend.model.dto.ReservationResponse;
import de.jordanmruczynski.backend.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/multiplex/reservations")
public class ReservationController {

    private final CinemaService cinemaService;

    public ReservationController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody @Valid ReservationRequest reservationRequest) {
        ReservationResponse reservationResponse = cinemaService.createReservation(reservationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationResponse);
    }

}
