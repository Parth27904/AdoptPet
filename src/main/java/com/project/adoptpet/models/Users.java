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
public class Users {

    @Id
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String location;
    private String role;
    private Timestamp created_at;
}
