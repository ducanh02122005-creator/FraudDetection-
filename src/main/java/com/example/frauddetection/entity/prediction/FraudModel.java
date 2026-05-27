package com.example.frauddetection.entity.prediction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudModel {
    @Id
    private Long id;

    private String modelVersion;

    private Float threshold;
}
