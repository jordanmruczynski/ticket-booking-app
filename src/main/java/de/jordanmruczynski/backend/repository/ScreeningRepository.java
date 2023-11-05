package de.jordanmruczynski.backend.repository;


import de.jordanmruczynski.backend.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    //@Query("SELECT s FROM Screening s JOIN s.movie m WHERE s.screeningStartTime BETWEEN :start AND :end ORDER BY m.title ASC")
    List<Screening> findAllByScreeningStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
