package com.example.frauddetection.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Double amount;
    private String merchant;
    private String category;
    private String location;
    private LocalDateTime date;
}
