package com.app.infrastructure.repository.jpa;

import com.app.domain.model.Cinema;
import com.app.domain.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCinemaRepository extends JpaRepository<Cinema, Long> {
}
