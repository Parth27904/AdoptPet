package com.project.adoptpet.repository;

import com.project.adoptpet.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByName(String name);
    List<Pet> findByType(String type);
    List<Pet> findByBreed(String breed);
    List<Pet> findByStatus(String status);
}
