package com.app.infrastructure.repository.impl;

import com.app.domain.model.Ticket;
import com.app.domain.repository.repositories.TicketRepository;
import com.app.infrastructure.repository.jpa.JpaTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {

    private final JpaTicketRepository jpaTicketRepository;
    @Override
    public Optional<Ticket> findOneById(Long id) {
        return jpaTicketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return jpaTicketRepository.findAll();
    }

    @Override
    public Optional<Ticket> save(Ticket ticket) {
        return Optional.of(jpaTicketRepository.save(ticket));
    }

    @Override
    public Long deleteById(Long id) {

       jpaTicketRepository.deleteById(id);
        return id;
    }
}
