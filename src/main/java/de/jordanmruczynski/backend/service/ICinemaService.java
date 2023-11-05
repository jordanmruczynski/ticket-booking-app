package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Reservation;
import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;
import de.jordanmruczynski.backend.model.dto.ReservationRequest;
import de.jordanmruczynski.backend.model.dto.ReservationResponse;
import de.jordanmruczynski.backend.model.dto.ScreeningDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ICinemaService {

        List<MovieScreeningsDTO> getAllScreenings(LocalDateTime start, LocalDateTime end);
        ReservationResponse createReservation(ReservationRequest request);

}
