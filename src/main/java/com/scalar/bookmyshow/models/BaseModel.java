package com.scalar.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass //Don't  create separate table for this instead put its attributes in every child class
public class BaseModel {
    @Id
    private Long id;
    private Date createdDate;
    private Date lastModifiedAt;
}
