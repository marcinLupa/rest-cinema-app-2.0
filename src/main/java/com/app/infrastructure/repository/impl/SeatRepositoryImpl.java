package com.app.infrastructure.repository.impl;

import com.app.domain.model.Seat;
import com.app.domain.repository.repositories.SeatRepository;
import com.app.infrastructure.repository.jpa.JpaSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl  implements SeatRepository {

    private final JpaSeatRepository jpaSeatRepository;
    @Override
    public Optional<Seat> findOneById(Long id) {
        return jpaSeatRepository.findById(id);
    }

    @Override
    public List<Seat> findAll() {
        return jpaSeatRepository.findAll();
    }

    @Override
    public Optional<Seat> save(Seat seat) {
        return Optional.of(jpaSeatRepository.save(seat));
    }

    @Override
    public Long deleteById(Long id) {
        jpaSeatRepository.deleteById(id);
        return id;
    }
}
