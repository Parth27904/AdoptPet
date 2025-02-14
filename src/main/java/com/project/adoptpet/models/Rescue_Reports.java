package com.project.adoptpet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rescue_Reports {

    @Id
    private int id;
    private int user_id;
    private String location;
    private String description;
    private String image_url;
    private String status;
    private Timestamp report_date;
}
