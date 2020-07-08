package com.app.domain.model;

import com.app.domain.model.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    private State state;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seat_id")
    private Seat seatId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seance_id")
    private Seance seanceId;

}
