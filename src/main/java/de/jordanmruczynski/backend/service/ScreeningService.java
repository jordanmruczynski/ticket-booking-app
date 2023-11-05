package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.exception.ResourceNotFoundException;
import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {
    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public Screening getScreeningById(Integer id) {
        return screeningRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Screening not found"));
    }
}
