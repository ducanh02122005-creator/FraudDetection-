package com.example.frauddetection.entity.transaction;


import com.example.frauddetection.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    private Long transactionId;

    private Double amount;

    private String merchant;

    private String category;

    private String location;

    private LocalDateTime date;



//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
