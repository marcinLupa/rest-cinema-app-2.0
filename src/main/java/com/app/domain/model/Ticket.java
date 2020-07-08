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
import java.math.BigDecimal;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal price;
    private BigDecimal discount;

    private User userId;
    private Seat seatId;
    private Seance seanceId;

}
