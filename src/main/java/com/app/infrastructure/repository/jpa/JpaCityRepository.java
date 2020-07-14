package com.app.infrastructure.repository.jpa;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCityRepository extends JpaRepository<City,Long> {
}
