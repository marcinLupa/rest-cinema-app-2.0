package com.app.infrastructure.repository.jpa;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeatRepository extends JpaRepository<Seat,Long> {
}
