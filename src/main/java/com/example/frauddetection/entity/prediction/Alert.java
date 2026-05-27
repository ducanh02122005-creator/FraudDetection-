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
public class Alert {
    @Id
    private Long id;

    private String type;

    private String message;

    private String status;
}
