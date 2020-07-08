package com.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private CinemaRoom cinemaRoom;
}
