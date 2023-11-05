package de.jordanmruczynski.backend.repository;

import de.jordanmruczynski.backend.model.ScreeningRoom;
import de.jordanmruczynski.backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //List<Seat> findAllByScreeningRoomAndIsAvailable(ScreeningRoom screeningRoom, boolean isAvailable);

    List<Seat> findAllByScreeningRoom(ScreeningRoom screeningRoom);

    Seat findByRowAndNumber(String row, Integer number);
}
