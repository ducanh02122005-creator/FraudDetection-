package com.example.frauddetection.entity.transaction;

import com.example.frauddetection.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSequence {
    @Id
    private Long id;

    private Long sequenceLength;

    @ManyToOne

    private User user;

//    @OneToMany
//    private List<Transaction> transactions;
}
