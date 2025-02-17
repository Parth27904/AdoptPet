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
    public List<Pet> getAllPets(@RequestParam(required = false) String name,
                                @RequestParam(required = false) String breed,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String status) {

        if(name != null){
            return petRepository.findByName(name);
        }else if(breed != null){
            return petRepository.findByBreed(breed);
        }else if(type != null){
            return petRepository.findByType(type);
        }else if(status != null) {
            return petRepository.findByStatus(status);
        }
        else{
            return petRepository.findAll();
        }
    }

    @PostMapping("/addPet")
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @DeleteMapping("/deletePet/{id}")
    public void deletePetById(@PathVariable("id") int id) {
        petRepository.deleteById(id);
    }

}
