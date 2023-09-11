package com.scalar.bookmyshow.service;

import com.scalar.bookmyshow.models.User;
import com.scalar.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User signUpuUser(String email,String password){
        User user = new User();
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));

        User savedUser  = userRepository.save(user);
        return savedUser;
    }
}
