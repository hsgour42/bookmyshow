package com.scalar.bookmyshow;

import com.scalar.bookmyshow.controllers.UserController;
import com.scalar.bookmyshow.dtos.SignUpUserRequestDto;
import com.scalar.bookmyshow.dtos.SignUpUserResponseDto;
import com.scalar.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //put all default value in table Or put the audit column default value like lastModifyDate..
public class BookmyshowApplication implements CommandLineRunner {
    private UserController userController;

    @Autowired
    public BookmyshowApplication(UserController userController){
        this.userController = userController;
    }
    @Override
    public void run(String... args) throws Exception {
        SignUpUserRequestDto request = new SignUpUserRequestDto();
        request.setEmail("hsgour@gmail.com");
        request.setPassword("himanshu123");

        SignUpUserResponseDto response = userController.signUpUser(request);


    }
    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }
}
