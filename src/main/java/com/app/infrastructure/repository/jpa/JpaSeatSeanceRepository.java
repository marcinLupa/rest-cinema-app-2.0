package com.app.infrastructure.repository.jpa;

import com.app.domain.model.SeatSeance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeatSeanceRepository  extends JpaRepository<SeatSeance,Long> {
}
