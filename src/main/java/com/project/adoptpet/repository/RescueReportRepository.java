package com.project.adoptpet.repository;

import com.project.adoptpet.models.Rescue_Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RescueReportRepository extends JpaRepository<Rescue_Reports,Integer> {
    List<Rescue_Reports> findByStatus(String status);
}
