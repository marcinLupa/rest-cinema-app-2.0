package com.app.domain.repository.repositories;

import com.app.domain.model.VerificationToken;
import com.app.domain.repository.GenericRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends GenericRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}