package com.pesuveritas.veritas.repository;

import com.pesuveritas.veritas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
