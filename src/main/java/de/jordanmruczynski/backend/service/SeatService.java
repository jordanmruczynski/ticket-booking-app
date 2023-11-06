package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.Seat;
import de.jordanmruczynski.backend.model.Ticket;
import de.jordanmruczynski.backend.repository.SeatRepository;
import de.jordanmruczynski.backend.repository.TicketRepository;
import de.jordanmruczynski.backend.service.interfaces.ISeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatService implements ISeatService {
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;

    public SeatService(SeatRepository seatRepository, TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Seat> getAvailableSeatsByScreening(Screening screening) {
        List<Seat> seats = seatRepository.findAllByScreeningRoom(screening.getScreeningRoom());

        List<Ticket> tickets = ticketRepository.findAllByScreening(screening);
        Set<Seat> takenSeats = tickets.stream().map(Ticket::getSeat).collect(Collectors.toSet());

        return seats.stream().filter(seat -> !takenSeats.contains(seat)).collect(Collectors.toList());
    }
}
