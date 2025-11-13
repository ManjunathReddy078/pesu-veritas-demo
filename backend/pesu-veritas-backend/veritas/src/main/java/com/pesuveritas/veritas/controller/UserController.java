package com.pesuveritas.veritas.controller;

import com.pesuveritas.veritas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
public String register(@RequestParam String name,
                       @RequestParam String email,
                       @RequestParam String role,
                       @RequestParam(required = false) String section,
                       @RequestParam(required = false) String facultyId) {
    return userService.registerUser(name, email, role, section, facultyId);
}

}
