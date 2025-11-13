package com.pesuveritas.veritas.service;

import com.pesuveritas.veritas.model.User;
import com.pesuveritas.veritas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Simulated whitelist (replace with DB or config in production)
    private List<String> whitelist = List.of("allowed1@domain.com", "allowed2@domain.com");

    public String registerUser(String name, String email, String role) {
        // Input validation
        if (name == null || email == null || role == null) {
            return "Error: Missing required fields";
        }

        // Whitelist check
        if (!whitelist.contains(email)) {
            return "Error: Unauthorized email";
        }

        // Duplicate check
        if (userRepository.findByEmail(email) != null) {
            return "Error: User already registered";
        }

        // Generate UUID
        String uuid = UUID.randomUUID().toString();

        // Save user
        User user = new User(name, email, role, uuid);
        userRepository.save(user);

        return "Registration successful! Your UUID: " + uuid;
    }
}
