package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Pet;
import com.project.adoptpet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/pets")
    public String getAllPets(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String breed,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false) String status,
                             Model model) {

        name = (name != null && name.isEmpty()) ? null : name;
        breed = (breed != null && breed.isEmpty()) ? null : breed;
        type = (type != null && type.isEmpty()) ? null : type;
        status = (status != null && status.isEmpty()) ? null : status;

        List<Pet> pets = petRepository.searchPets(name, breed, type, status);

        model.addAttribute("pets", pets);
        return "pets";
    }


    @GetMapping("/addPet")
    public String showAddPetPage(Model model) {
        model.addAttribute("pet", new Pet());
        return "add_pets";
    }

    @PostMapping("/addPet")
    public String addPet(@ModelAttribute Pet pet) {
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/deletePet/{id}")
    public String deletePetById(@PathVariable("id") int id) {
        petRepository.deleteById(id);
        return "redirect:/pets";
    }
}
