package com.app.infrastructure.repository.impl;

import com.app.domain.model.CinemaRoom;
import com.app.domain.repository.repositories.CinemaRoomRepository;
import com.app.infrastructure.repository.jpa.JpaCinemaRepository;
import com.app.infrastructure.repository.jpa.JpaCinemaRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CinemaRoomRepositoryImpl implements CinemaRoomRepository {

    private final JpaCinemaRoomRepository jpaCinemaRoomRepository;

    @Override
    public Optional<CinemaRoom> findOneById(Long id) {
        return jpaCinemaRoomRepository.findById(id);
    }

    @Override
    public List<CinemaRoom> findAll() {
        return jpaCinemaRoomRepository.findAll();
    }

    @Override
    public Optional<CinemaRoom> saveOrUpdate(CinemaRoom cinemaRoom) {
        return Optional.of(jpaCinemaRoomRepository.save(cinemaRoom));
    }

    @Override
    public Long deleteById(Long id) {
        jpaCinemaRoomRepository.deleteById(id);
        return id;
    }
}
