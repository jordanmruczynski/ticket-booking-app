package de.jordanmruczynski.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "screening_rooms")
public class ScreeningRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "screeningRoom")
    private Set<Seat> seats;

    public ScreeningRoom() {
    }

    public ScreeningRoom(Integer id, String name, Set<Seat> seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

    public ScreeningRoom(String name, Set<Seat> seats) {
        this.name = name;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
