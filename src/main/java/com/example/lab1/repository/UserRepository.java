package com.example.lab1.repository;

import com.example.lab1.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    User findUserById(int id);
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
