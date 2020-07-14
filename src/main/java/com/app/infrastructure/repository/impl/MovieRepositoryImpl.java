package com.app.infrastructure.repository.impl;

import com.app.domain.model.Movie;
import com.app.domain.repository.repositories.MovieRepository;
import com.app.infrastructure.repository.jpa.JpaMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final JpaMovieRepository jpaMovieRepository;
    @Override
    public Optional<Movie> findOneById(Long id) {
        return jpaMovieRepository.findById(id);
    }

    @Override
    public List<Movie> findAll() {
        return jpaMovieRepository.findAll();
    }

    @Override
    public Optional<Movie> save(Movie movie) {
        return Optional.of(jpaMovieRepository.save(movie));
    }

    @Override
    public Long deleteById(Long id) {
        jpaMovieRepository.deleteById(id);
        return id;
    }
}
