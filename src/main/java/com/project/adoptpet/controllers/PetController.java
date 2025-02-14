package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Pet;
import com.project.adoptpet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PostMapping("/addPet")
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deletePetById(@PathVariable("id") int id) {
        petRepository.deleteById(id);
    }

    @GetMapping("/petsByName/{name}")
    public List<Pet> getPetByName(@PathVariable("name") String name) {
        return petRepository.findByName(name);
    }

    @GetMapping("/petsByBreed/{breed}")
    public List<Pet> findByBreed(@PathVariable("breed") String breed) {
        return petRepository.findByBreed(breed);
    }

    @GetMapping("/petsByType/{type}")
    public List<Pet> findByType(@PathVariable("type") String type) {
        return petRepository.findByType(type);
    }

    @GetMapping("/petsByStatus/{status}")
    public List<Pet> findByStatus(@PathVariable("status") String status) {
        return petRepository.findByStatus(status);
    }

}
