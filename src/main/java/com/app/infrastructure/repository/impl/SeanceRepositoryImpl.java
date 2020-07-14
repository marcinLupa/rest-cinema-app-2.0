package com.app.infrastructure.repository.impl;

import com.app.domain.model.Seance;
import com.app.domain.repository.repositories.SeanceRepository;
import com.app.infrastructure.repository.jpa.JpaSeanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SeanceRepositoryImpl implements SeanceRepository {
    private final JpaSeanceRepository jpaSeanceRepository;


    @Override
    public Optional<Seance> findOneById(Long id) {
        return jpaSeanceRepository.findById(id);
    }

    @Override
    public List<Seance> findAll() {
        return jpaSeanceRepository.findAll();
    }

    @Override
    public Optional<Seance> saveOrUpdate(Seance seance) {
        return Optional.of(jpaSeanceRepository.save(seance));
    }

    @Override
    public Long deleteById(Long id) {

        jpaSeanceRepository.deleteById(id);
        return id;
    }
}
