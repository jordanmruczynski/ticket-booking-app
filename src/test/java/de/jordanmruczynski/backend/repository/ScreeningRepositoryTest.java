package de.jordanmruczynski.backend.repository;

import de.jordanmruczynski.backend.AbstractContainers;
import de.jordanmruczynski.backend.model.Movie;
import de.jordanmruczynski.backend.model.Screening;
import de.jordanmruczynski.backend.model.ScreeningRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ScreeningRepositoryTest extends AbstractContainers {

    @Autowired
    private ScreeningRepository underTest;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ScreeningRoomRepository screeningRoomRepository;

    @Test
    void itShouldReturnAllScreeningsBetweenTimeInterval() {
        // Given
        Movie movie = new Movie( "TestTitle", "TestDescription", "TestGenre", 8.5, 120);
        movieRepository.save(movie);
        ScreeningRoom screeningRoom = new ScreeningRoom(1, "A");
        screeningRoomRepository.save(screeningRoom);
        LocalDateTime timeNow = LocalDateTime.now();
        Screening screening1 = new Screening(movie, screeningRoom, timeNow);
        Screening screening2 = new Screening(movie, screeningRoom, timeNow.plusHours(2));
        Screening screening3 = new Screening(movie, screeningRoom, timeNow.plusHours(5));
        underTest.save(screening1);
        underTest.save(screening2);
        underTest.save(screening3);

        // When
        var screenings = underTest.findAllByScreeningStartTimeBetween(timeNow, timeNow.plusHours(3));
        System.out.println(screenings.size());

        // Then
        assertThat(screenings).hasSize(2);
    }
}