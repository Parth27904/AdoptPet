package com.project.adoptpet.models;

import jakarta.persistence.Column;
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
public class Adoption_Requests {

    @Id
    private int id;
    @Column(name="pet_id")
    private int petId;
    @Column(name="user_id")
    private int userId;
    private String status;
    private Timestamp request_date;

}
