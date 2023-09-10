package com.scalar.bookmyshow.controllers;

import com.scalar.bookmyshow.dtos.BookTicketRequestDto;
import com.scalar.bookmyshow.dtos.BookTicketResponseDto;
import com.scalar.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService =  ticketService;
    }
    public BookTicketResponseDto bookTicket(BookTicketRequestDto request){
        return null;
    }
}
