package com.app.infrastructure.repository.impl;

import com.app.domain.model.User;
import com.app.domain.repository.repositories.UserRepository;
import com.app.infrastructure.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    @Override
    public Optional<User> findOneById(Long id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public Optional<User> saveOrUpdate(User user) {
        return Optional.of(jpaUserRepository.save(user));
    }

    @Override
    public Long deleteById(Long id) {
    jpaUserRepository.deleteById(id);
        return id;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email);
    }
}
