package com.app.infrastructure.repository.impl;

import com.app.domain.model.City;
import com.app.domain.repository.repositories.CityRepository;
import com.app.infrastructure.repository.jpa.JpaCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {

    private  final JpaCityRepository jpaCityRepository;
    @Override
    public Optional<City> findOneById(Long id) {
        return jpaCityRepository.findById(id);
    }

    @Override
    public List<City> findAll() {
        return jpaCityRepository.findAll();
    }

    @Override
    public Optional<City> save(City city) {
        return Optional.of(jpaCityRepository.save(city));
    }

    @Override
    public Long deleteById(Long id) {
        jpaCityRepository.deleteById(id);
        return id;
    }
}
