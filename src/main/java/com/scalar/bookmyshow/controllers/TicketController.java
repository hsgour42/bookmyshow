package com.scalar.bookmyshow.controllers;

import com.scalar.bookmyshow.dtos.BookTicketRequestDto;
import com.scalar.bookmyshow.dtos.BookTicketResponseDto;
import com.scalar.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService =  ticketService;
    }
    public BookTicketResponseDto bookTicket(BookTicketRequestDto request){
        BookTicketResponseDto response = new BookTicketResponseDto();
//        try{
//           // ticketService.bookTicket(request.getSeatIds(),request.getShowId(),request.getUserId());
//        }catch (TimeoutException e){
//            response.setStatus("FAILURE");
//            response.setMessage("Something is wrong");
//        }
        return response;
    }
}
