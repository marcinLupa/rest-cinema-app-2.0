package com.app.domain.repository.repositories;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.User;
import com.app.domain.repository.GenericRepository;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
