package com.scalar.bookmyshow.repositories;

import com.scalar.bookmyshow.models.Seat;
import com.scalar.bookmyshow.models.Show;
import com.scalar.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat , Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);
    @Override
    ShowSeat save(ShowSeat showSeat);
}
