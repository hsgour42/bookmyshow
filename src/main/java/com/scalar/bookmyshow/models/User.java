package com.scalar.bookmyshow.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private int age;
    private String name;
    private  String email;
    private String password;
    private String phoneNumber;
}
