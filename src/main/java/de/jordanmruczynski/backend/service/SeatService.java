package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.Seat;
import de.jordanmruczynski.backend.model.Ticket;
import de.jordanmruczynski.backend.repository.SeatRepository;
import de.jordanmruczynski.backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;

    public SeatService(SeatRepository seatRepository, TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Seat> getAvailableSeatsByScreening(Screening screening) {
        // Pobierz wszystkie miejsca w sali
        List<Seat> seats = seatRepository.findAllByScreeningRoom(screening.getScreeningRoom());

        // Pobierz zajęte miejsca na podstawie biletów
        List<Ticket> tickets = ticketRepository.findAllByScreening(screening);
        Set<Seat> takenSeats = tickets.stream().map(Ticket::getSeat).collect(Collectors.toSet());

        // Zwróć tylko dostępne miejsca
        return seats.stream().filter(seat -> !takenSeats.contains(seat)).collect(Collectors.toList());
    }
}
