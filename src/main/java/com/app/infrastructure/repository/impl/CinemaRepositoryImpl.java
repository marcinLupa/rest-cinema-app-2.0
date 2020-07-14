package com.app.infrastructure.repository.impl;

import com.app.domain.model.Cinema;
import com.app.domain.repository.repositories.CinemaRepository;
import com.app.infrastructure.repository.jpa.JpaCinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CinemaRepositoryImpl implements CinemaRepository {

    private final JpaCinemaRepository jpaCinemaRepository;

    @Override
    public Optional<Cinema> findOneById(Long id) {
        return jpaCinemaRepository.findById(id);
    }

    @Override
    public List<Cinema> findAll() {
        return jpaCinemaRepository.findAll();
    }

    @Override
    public Optional<Cinema> save(Cinema cinema) {
        return Optional.of(jpaCinemaRepository.save(cinema));
    }

    @Override
    public Long deleteById(Long id) {
        jpaCinemaRepository.deleteById(id);
        return id;
    }
}
