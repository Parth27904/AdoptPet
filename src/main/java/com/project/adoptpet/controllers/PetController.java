package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Pet;
import com.project.adoptpet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable("id") int id) {
        return petRepository.findById(id).orElse(null);
    }
}
