package com.app.infrastructure.repository.jpa;

import com.app.domain.model.CinemaRoom;
import com.app.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<Ticket,Long> {
}
