package com.app.infrastructure.repository.jpa;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<Movie,Long> {
}
