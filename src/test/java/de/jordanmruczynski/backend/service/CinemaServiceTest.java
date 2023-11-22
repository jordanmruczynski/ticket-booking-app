package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Movie;
import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.ScreeningRoom;
import de.jordanmruczynski.backend.model.dto.MovieScreeningsDTO;
import de.jordanmruczynski.backend.repository.ReservationRepository;
import de.jordanmruczynski.backend.repository.ScreeningRepository;
import de.jordanmruczynski.backend.repository.SeatRepository;
import de.jordanmruczynski.backend.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CinemaServiceTest {

    @Mock
    private ScreeningRepository screeningRepository;
    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private SeatRepository seatRepository;
    private CinemaService underTest;

    @Test
    void itShouldGetAllScreenings() {
        // Given
    }
}