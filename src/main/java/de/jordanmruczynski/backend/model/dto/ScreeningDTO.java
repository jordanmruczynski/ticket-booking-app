package de.jordanmruczynski.backend.model.dto;

import de.jordanmruczynski.backend.model.ScreeningRoom;
import de.jordanmruczynski.backend.model.Seat;

import java.util.List;
import java.util.Map;

public record ScreeningDTO(
        String screeningRoomName,
        List<String> availableSeats) {
}
