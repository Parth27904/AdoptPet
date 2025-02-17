package com.project.adoptpet.repository;

import com.project.adoptpet.models.Adoption_Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<Adoption_Requests, Integer> {
    List<Adoption_Requests> findByStatus(String status);
    List<Adoption_Requests> findByUserId(int userId);
    List<Adoption_Requests> findByPetId(int petId);
}
