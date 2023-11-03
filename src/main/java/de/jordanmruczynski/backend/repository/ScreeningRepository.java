package de.jordanmruczynski.backend.repository;


import de.jordanmruczynski.backend.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    List<Screening> findAllByScreeningTimeBetween(LocalDateTime start, LocalDateTime end);

}
