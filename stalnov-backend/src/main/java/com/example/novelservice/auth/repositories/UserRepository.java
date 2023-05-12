package com.example.novelservice.auth.repositories;

import com.example.novelservice.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
