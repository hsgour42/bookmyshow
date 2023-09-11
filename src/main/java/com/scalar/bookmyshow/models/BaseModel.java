package com.scalar.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})  //class that has something to audit
@MappedSuperclass //Don't  create separate table for this instead put its attributes in every child class
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedAt;
}
