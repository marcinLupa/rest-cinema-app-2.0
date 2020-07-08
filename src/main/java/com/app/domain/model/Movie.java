package com.app.domain.model;

import com.app.domain.model.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String Title;
    private Genre genre;
    private LocalDate startEmissionTime;
    private LocalDate stopEmissionTime;

}
