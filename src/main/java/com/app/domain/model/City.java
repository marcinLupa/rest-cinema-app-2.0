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
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue
    private Long id;
}
