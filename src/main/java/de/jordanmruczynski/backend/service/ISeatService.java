package de.jordanmruczynski.backend.service;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.Seat;

import java.util.List;

public interface ISeatService {

    List<Seat> getAvailableSeatsByScreening(Screening screening);
}
