package de.jordanmruczynski.backend.controller;

import de.jordanmruczynski.backend.model.Reservation;
import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;
import de.jordanmruczynski.backend.model.dto.ReservationRequest;
import de.jordanmruczynski.backend.model.dto.ScreeningDTO;
import de.jordanmruczynski.backend.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/multiplex/movies")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MovieScreeningsDTO>> getMovies(
            @RequestParam("start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime start,
            @RequestParam("end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime end) {
        return ResponseEntity.ok(cinemaService.getAllScreenings(start, end));
    }
}
