package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ICinemaService {

    List<MovieScreeningsDTO> getAllScreenings(LocalDateTime start, LocalDateTime end);

}
