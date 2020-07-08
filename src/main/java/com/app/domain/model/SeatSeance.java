package com.app.domain.model;

import com.app.domain.model.enums.State;
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
@Table(name = "seat_seances")
public class SeatSeance {

    @Id
    @GeneratedValue
    private Long id;
    private Seat seatId;
    private Seance seanceId;
    private State state;
}
