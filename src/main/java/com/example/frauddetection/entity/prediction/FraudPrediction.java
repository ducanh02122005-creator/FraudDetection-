package com.example.frauddetection.entity.prediction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudPrediction {

    @Id
    private Long predictionId;

    private Float riskScore;

    private Boolean prediction;

    private LocalDateTime create_at;
}
