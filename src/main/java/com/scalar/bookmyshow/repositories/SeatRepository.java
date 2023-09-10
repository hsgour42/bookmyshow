package com.scalar.bookmyshow.repositories;

import com.scalar.bookmyshow.models.Seat;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Which object get and what is the Data type of that object <Seat , Long>
public interface SeatRepository extends JpaRepository<Seat , Long> {
    List<Seat> findAllByIdIn(List<Long> seatIds);

}
