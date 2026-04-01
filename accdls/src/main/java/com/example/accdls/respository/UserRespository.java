package com.example.accdls.respository;

import com.example.accdls.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, String> {
    boolean existsUsersByUsername(String username);
    Optional<User> findByUsername(String username);
}


