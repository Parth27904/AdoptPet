package com.project.adoptpet.controllers;

import com.project.adoptpet.models.Rescue_Reports;
import com.project.adoptpet.repository.RescueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RescueReportController {

    @Autowired
    RescueReportRepository rescueReportRepository;

    @GetMapping("/rescueReports")
    public List<Rescue_Reports> getRescueReports() {
        return rescueReportRepository.findAll();
    }

    @GetMapping("/rescueReports/{id}")
    public Rescue_Reports getRescueReportsById(@PathVariable("id") int id) {
        return rescueReportRepository.findById(id).orElse(null);
    }

    @PostMapping("/addRescueReport")
    public void addRescueReport(@RequestBody Rescue_Reports rescue_report) {
        rescueReportRepository.save(rescue_report);
    }

    @DeleteMapping("/deleteRescueReport/{id}")
    public void deleteRescueReportById(@PathVariable("id") int id) {
        rescueReportRepository.deleteById(id);
    }

    @GetMapping("/rescueReportsByStatus/{status}")
    public List<Rescue_Reports> findRescueReportByStatus(@PathVariable("status") String status) {
        return rescueReportRepository.findByStatus(status);
    }

}
