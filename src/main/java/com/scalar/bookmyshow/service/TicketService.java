package com.scalar.bookmyshow.service;

import com.scalar.bookmyshow.exceptions.InvalidArgumentException;
import com.scalar.bookmyshow.exceptions.SeatNotAvailableException;
import com.scalar.bookmyshow.models.*;
import com.scalar.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    @Autowired
    public TicketService(SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository
    ){
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    //If not able to take lock in 2 sec roll back (Timeout)
    // Transaction cannot be run in private method
    @Transactional(isolation = Isolation.SERIALIZABLE , timeout = 2)
    public Ticket bookTicket(List<Long> seatIds ,Long showId ,Long userId) throws InvalidArgumentException, SeatNotAvailableException {
        //1. For these seatIds get the corresponding show seat object for seat : getSeatsForIds(seatIs)
        //2. Check the status of all the show seats : getShowSeatsForSeats(seats)
        //2.a: If every seat is available
        //3.a: Lock every seat(set the status to be LOCKED)
        //4.a: Create the ticket and return it
        //2.b: Some of the seats are not available
        //3.b: throw an exception

        //getSeatsForIds(seatIs)
        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        Optional<Show> showOptional = showRepository.findById(showId);

        if(showOptional.isEmpty()){
            throw new InvalidArgumentException(
                    "Show by: "+ showId + "doesn't exists"
            );
        }

        //getShowSeatsForSeats(seats)
        //Lock will be taken here
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats,showOptional.get());

        //Check all seats
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException(
                        "Seat "+ showSeat.getSeat() + " not available"
                );
            }
        }

        List<ShowSeat> savedShowSeat = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockAt(new Date());
            savedShowSeat.add(showSeatRepository.save(showSeat));
        }

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new InvalidArgumentException("User with id: " + userId + " doesn't exist.");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(optionalUser.get());
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(showOptional.get());
        ticket.setSeats(seats);
        ticket.setTimeOfBooking(new Date());
        ticket.setAmount(0);
        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }
    //Lock is released
}
