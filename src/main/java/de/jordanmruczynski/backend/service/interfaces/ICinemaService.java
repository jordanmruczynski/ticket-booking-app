package de.jordanmruczynski.backend.service.interfaces;

import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;
import de.jordanmruczynski.backend.model.dto.ReservationRequest;
import de.jordanmruczynski.backend.model.dto.ReservationResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface ICinemaService {

        List<MovieScreeningsDTO> getAllScreenings(LocalDateTime start, LocalDateTime end);
        ReservationResponse createReservation(ReservationRequest request);

}
