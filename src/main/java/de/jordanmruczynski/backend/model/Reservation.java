package de.jordanmruczynski.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @OneToMany(mappedBy = "reservation")
    private Set<Ticket> tickets;

    public Reservation() {
    }

    public Reservation(Integer id, String name, String surname, LocalDateTime reservationTime, Screening screening, Set<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.reservationTime = reservationTime;
        this.screening = screening;
        this.tickets = tickets;
    }

    public Reservation(String name, String surname, LocalDateTime reservationTime, Screening screening, Set<Ticket> tickets) {
        this.name = name;
        this.surname = surname;
        this.reservationTime = reservationTime;
        this.screening = screening;
        this.tickets = tickets;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
