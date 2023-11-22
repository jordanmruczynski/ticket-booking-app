package de.jordanmruczynski.backend.model.dto;

import de.jordanmruczynski.backend.model.ticketshandler.TicketType;

public record TicketRequest(
        Integer seatId,
        TicketType ticketType
) {
}
