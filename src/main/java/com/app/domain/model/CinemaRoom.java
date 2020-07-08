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
@Table(name = "cinema_rooms")
public class CinemaRoom {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer rowsNumber;
    private Integer places;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "cinemaRoom")
    private Set<Seat> seats;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "cinemaRoom")
    private Set<Seance> seance;

}
