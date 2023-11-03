package de.jordanmruczynski.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_room_id", nullable = false)
    private ScreeningRoom screeningRoom;

    @Column(nullable = false)
    private LocalDateTime screeningTime;

    public Screening() {
    }

    public Screening(Integer id, Movie movie, ScreeningRoom screeningRoom, LocalDateTime screeningTime) {
        this.id = id;
        this.movie = movie;
        this.screeningRoom = screeningRoom;
        this.screeningTime = screeningTime;
    }

    public Screening(Movie movie, ScreeningRoom screeningRoom, LocalDateTime screeningTime) {
        this.movie = movie;
        this.screeningRoom = screeningRoom;
        this.screeningTime = screeningTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public LocalDateTime getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(LocalDateTime screeningTime) {
        this.screeningTime = screeningTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


}
