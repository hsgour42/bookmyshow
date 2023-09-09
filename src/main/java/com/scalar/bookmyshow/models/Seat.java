package com.scalar.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @Column(name = "rowz")
    private int rows;
    @Column(name = "colz")
    private int cols;
    @ManyToOne
    private SeatType seatType;
}
