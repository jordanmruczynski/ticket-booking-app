package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;
import de.jordanmruczynski.backend.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CinemaService implements ICinemaService {

    private final ScreeningRepository screeningService;

    public CinemaService(ScreeningRepository screeningService) {
        this.screeningService = screeningService;
    }

    @Override
    public List<MovieScreeningsDTO> getAllScreenings(LocalDateTime start, LocalDateTime end) {
        final List<Screening> screenings = screeningService.findAllByScreeningTimeBetween(start, end);

        final Map<String, List<LocalDateTime>> screeningsMap = screenings.stream()
                .collect(Collectors.groupingBy(
                        screening -> screening.getMovie().getTitle(),
                        Collectors.mapping(Screening::getScreeningTime, Collectors.toList())
                ));

        List<MovieScreeningsDTO> result = new ArrayList<>();
        screeningsMap.forEach((title, times) -> result.add(new MovieScreeningsDTO(title, times)));

        return result;
    }
}
