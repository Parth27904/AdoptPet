package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Users;
import com.project.adoptpet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/usersByName/{name}")
    public List<Users> getUsersByName(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody Users user) {
        userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/usersByRole/{role}")
    public List<Users> getUserByRole(@PathVariable("role") String role) {
        return userRepository.findByRole(role);
    }

}
