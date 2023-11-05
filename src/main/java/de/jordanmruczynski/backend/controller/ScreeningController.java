package de.jordanmruczynski.backend.controller;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.Seat;
import de.jordanmruczynski.backend.model.dto.ScreeningRoomAvailabilityDto;
import de.jordanmruczynski.backend.model.dto.SeatDto;
import de.jordanmruczynski.backend.service.ScreeningService;
import de.jordanmruczynski.backend.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/multiplex/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;
    private final SeatService seatService;

    public ScreeningController(ScreeningService screeningService, SeatService seatService) {
        this.screeningService = screeningService;
        this.seatService = seatService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{screeningId}/seats")
    public ResponseEntity<ScreeningRoomAvailabilityDto> getScreeningRoomSeats(@PathVariable("screeningId") Integer screeningId) {
        Screening screening = screeningService.getScreeningById(screeningId);
        List<Seat> availableSeats = seatService.getAvailableSeatsByScreening(screening);

        // Tworzenie listy dostępnych miejsc jako lista rekordów SeatDto
        List<SeatDto> seatsDto = availableSeats.stream()
                .map(seat -> new SeatDto(seat.getRow(), seat.getNumber()))
                .collect(Collectors.toList());

        // Utworzenie rekordu ScreeningRoomAvailabilityDto
        ScreeningRoomAvailabilityDto dto = new ScreeningRoomAvailabilityDto(
                screening.getScreeningRoom().getName(),
                seatsDto
        );

        return ResponseEntity.ok(dto);
    }
}
