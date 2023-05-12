package com.example.novelservice.repositories;

import com.example.novelservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public boolean existsByUsername(String username);
}
