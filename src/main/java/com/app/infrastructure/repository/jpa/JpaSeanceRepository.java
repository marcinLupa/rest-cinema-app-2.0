package com.app.infrastructure.repository.jpa;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeanceRepository extends JpaRepository<Seance,Long> {
}
