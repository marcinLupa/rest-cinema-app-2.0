package com.app.infrastructure.repository.impl;

import com.app.domain.model.SeatSeance;
import com.app.domain.repository.repositories.SeatSeanceRepository;
import com.app.infrastructure.repository.jpa.JpaSeatSeanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class SeatSeanceRepositoryImpl implements SeatSeanceRepository {

    private final JpaSeatSeanceRepository jpaSeatSeanceRepository;
    @Override
    public Optional<SeatSeance> findOneById(Long id) {
        return jpaSeatSeanceRepository.findById(id);
    }

    @Override
    public List<SeatSeance> findAll() {
        return jpaSeatSeanceRepository.findAll();
    }

    @Override
    public Optional<SeatSeance> save(SeatSeance seatSeance) {
        return Optional.of(jpaSeatSeanceRepository.save(seatSeance));
    }

    @Override
    public Long deleteById(Long id) {
        jpaSeatSeanceRepository.deleteById(id);
        return id;
    }
}
