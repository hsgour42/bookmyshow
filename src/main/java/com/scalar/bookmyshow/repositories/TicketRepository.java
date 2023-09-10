package com.scalar.bookmyshow.repositories;

import com.scalar.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    Ticket save(Ticket ticket);
}
