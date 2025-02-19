package com.project.adoptpet.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String breed;
    private String type;
    private String health_status;
    private String image_url;
    private int center_id;
    private String status;

    @Column(nullable = false, updatable = false)
    private Timestamp created_at;

    @PrePersist
    protected void onCreate() {
        created_at = Timestamp.from(Instant.now());
    }
}
