package com.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    private Integer placeNumber;
    private Integer rowNumber;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "seatId")
    private Set<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CinemaRoom cinemaRoom;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "seatId")
    private Set<SeatSeance> seatSeances;

}
