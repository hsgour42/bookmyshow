package com.scalar.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<String> seatNumbers;
    private String auditoriumName;
    private String status;
    private String message;
}
