package com.scalar.bookmyshow.repositories;

import com.scalar.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long userId);
    User save(User user);
}
