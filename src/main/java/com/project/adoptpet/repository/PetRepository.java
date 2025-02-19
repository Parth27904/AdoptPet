package com.project.adoptpet.repository;

import com.project.adoptpet.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT p FROM Pet p WHERE " +
            "(:name IS NULL OR p.name LIKE %:name%) AND " +
            "(:breed IS NULL OR p.breed LIKE %:breed%) AND " +
            "(:type IS NULL OR p.type LIKE %:type%) AND " +
            "(:status IS NULL OR p.status LIKE %:status%)")
    List<Pet> searchPets(@Param("name") String name, @Param("breed") String breed,
                         @Param("type") String type, @Param("status") String status);

}
