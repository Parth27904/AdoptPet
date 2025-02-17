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
    public List<Users> getAllUsers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String role,
                                   @RequestParam(required = false) Integer id) {
        if(name != null){
            return userRepository.findByName(name);
        }else if(role != null){
            return userRepository.findByRole(role);
        }else if(id != null){
            return userRepository.findById(id).map(List::of).orElse(null);
        }
        else {
            return userRepository.findAll();
        }
    }


    @PostMapping("/addUser")
    public void addUser(@RequestBody Users user) {
        userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }
}
