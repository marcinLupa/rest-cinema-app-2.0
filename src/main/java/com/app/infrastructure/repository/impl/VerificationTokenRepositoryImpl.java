package com.app.infrastructure.repository.impl;

import com.app.domain.model.VerificationToken;
import com.app.domain.repository.repositories.VerificationTokenRepository;
import com.app.infrastructure.repository.jpa.JpaVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

    private final JpaVerificationTokenRepository jpaVerificationTokenRepository;

    @Override
    public Optional<VerificationToken> save(VerificationToken verificationToken) {
        return Optional.of(jpaVerificationTokenRepository.save(verificationToken));
    }

    @Override
    public Long deleteById(Long id) {
        jpaVerificationTokenRepository.deleteById(id);
        return id;
    }

    @Override
    public Optional<VerificationToken> findOneById(Long aLong) {
        return jpaVerificationTokenRepository.findById(aLong);
    }

    @Override
    public List<VerificationToken> findAll() {
        return jpaVerificationTokenRepository.findAll();
    }


    @Override
    public Optional<VerificationToken> findByToken(String token) {
        return jpaVerificationTokenRepository.findByToken(token);
    }
}