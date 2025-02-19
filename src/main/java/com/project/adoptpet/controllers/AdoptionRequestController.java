package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Adoption_Requests;
import com.project.adoptpet.repository.AdoptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdoptionRequestController {

    @Autowired
    AdoptionRequestRepository repository;

    @GetMapping("/requests")
    public List<Adoption_Requests> getAdoptionRequests(@RequestParam(required = false) Integer id,
                                                       @RequestParam(required = false) String status,
                                                       @RequestParam(required = false) Integer userId,
                                                       @RequestParam(required = false) Integer petId) {
        
        if(id != null) {
            return repository.findById(id).map(List::of).orElse(null);
        } else if (status != null) {
            return repository.findByStatus(status);
        }else if(userId != null) {
            return repository.findByUserId(userId);
        }else if(petId != null) {
            return repository.findByPetId(petId);
        }
        return repository.findAll();
    }

    @PostMapping("/addRequests")
    public Adoption_Requests addAdoptionRequest(@RequestBody Adoption_Requests request) {
        return repository.save(request);
    }

    @DeleteMapping("/deleteRequest/{id}")
    public void deleteAdoptionRequest(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

}
