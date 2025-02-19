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

    @GetMapping("/reports")
    public List<Rescue_Reports> getRescueReports(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String status
    ) {
        if (id != null) {
            return rescueReportRepository.findById(id)
                    .map(List::of)
                    .orElse(null);
        } else if (status != null) {
            return rescueReportRepository.findByStatus(status);
        } else {
            return rescueReportRepository.findAll();
        }
    }


    @PostMapping("/addReport")
    public void addRescueReport(@RequestBody Rescue_Reports rescue_report) {
        rescueReportRepository.save(rescue_report);
    }

    @DeleteMapping("/deleteReport/{id}")
    public void deleteRescueReportById(@PathVariable("id") int id) {
        rescueReportRepository.deleteById(id);
    }

}
