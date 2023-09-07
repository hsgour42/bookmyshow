package com.scalar.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private int amount;
    private Date timeOfBooking;
    private List<Seat> seats;
    private User bookedBy;
    private Show show;
    private List<Payment> payments;
    private TicketStatus ticketStatus;
}
