package de.jordanmruczynski.backend.model.ticketshandler;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketPricesConfig ticketPricesConfig;

    public TicketService(TicketPricesConfig ticketPricesConfig) {
        this.ticketPricesConfig = ticketPricesConfig;
    }

    public double calculatePrice(TicketType ticketType, int quantity) {
        return switch (ticketType) {
            case ADULT -> ticketPricesConfig.getAdult() * quantity;
            case STUDENT -> ticketPricesConfig.getStudent() * quantity;
            case CHILD -> ticketPricesConfig.getChild() * quantity;
            default -> throw new IllegalArgumentException("Unknown ticket type: " + ticketType);
        };
    }
}
