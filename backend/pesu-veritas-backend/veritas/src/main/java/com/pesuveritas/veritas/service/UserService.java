package com.pesuveritas.veritas.service;

import com.pesuveritas.veritas.model.AppUser;
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
    private List<String> whitelist = List.of(
    "seelammanjunathreddy6@gmail.com",
    "seelammouneswarreddy5@gmail.com"
);

public String registerUser(String name, String email, String role, String section, String facultyId) {
    if (name == null || email == null || role == null) {
        return "Error: Name, email, and role are required";
    }
    if (!whitelist.contains(email)) {
        return "Error: Unauthorized email";
    }
    if (userRepository.findByEmail(email) != null) {
        return "Error: User already registered";
    }
    if ("student".equalsIgnoreCase(role)) {
        if (section == null || section.trim().isEmpty()) {
            return "Error: Section is required for students";
        }
    }
    else if ("faculty".equalsIgnoreCase(role)) {
        if (facultyId == null || facultyId.trim().isEmpty()) {
            return "Error: Faculty ID is required for faculty";
        }
    }
    else {
        return "Error: Invalid role, must be 'student' or 'faculty'";
    }
    String uuid = UUID.randomUUID().toString();
    AppUser user = new AppUser(name, email, role, uuid, section, facultyId);
    userRepository.save(user);

    return "Registration successful! Your UUID: " + uuid;
}
}
