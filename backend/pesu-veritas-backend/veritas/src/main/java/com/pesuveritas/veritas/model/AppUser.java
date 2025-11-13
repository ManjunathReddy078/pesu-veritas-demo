package com.pesuveritas.veritas.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user7")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String role; // student or faculty
    private String uuid; // unique identifier
    private String section;    // For students only
    private String facultyId; // For faculty only

    public AppUser() {} // default constructor (required)

    public AppUser(String name, String email, String role, String uuid, String section, String facultyId) {
    this.name = name;
    this.email = email;
    this.role = role;
    this.uuid = uuid;
    this.section = section;
    this.facultyId = facultyId;
}



    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
    
    public String getFacultyId() { return facultyId; }
    public void setFacultyId(String facultyId) { this.facultyId = facultyId; }
}

