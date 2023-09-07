package com.scalar.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @OneToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private Language language;
}
