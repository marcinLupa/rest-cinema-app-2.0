package com.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "seances")
public class Seance {

    @Id
    @GeneratedValue
    private Long id;


    private LocalDateTime seanceDate;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "seanceId")
    private Set<Ticket> tickets;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "seanceId")
    private Set<SeatSeance> seatSeances;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CinemaRoom cinemaRoom;
}
