package de.jordanmruczynski.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class SeatAlreadyReservedException extends RuntimeException{

    public SeatAlreadyReservedException(String message) {
        super(message);
    }
}
