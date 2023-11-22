package de.jordanmruczynski.backend.repository;

import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.Seat;
import de.jordanmruczynski.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByScreening(Screening screening);

    @Query("SELECT t.seat FROM Ticket t WHERE t.screening = :screening")
    Set<Seat> findReservedSeatsByScreening(@Param("screening") Screening screening);
}
