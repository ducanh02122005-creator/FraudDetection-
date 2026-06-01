package com.example.frauddetection.service.transactionService;

import com.example.frauddetection.dtos.transaction.TransactionRequest;
import com.example.frauddetection.dtos.transaction.TransactionResponse;
import com.example.frauddetection.entity.transaction.Transaction;
import com.example.frauddetection.entity.user.User;
import com.example.frauddetection.repository.transactionRepository.TransactionRepository;
import com.example.frauddetection.repository.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CreateTransactionService {
    private final TransactionRepository repository;
    private final UserRepository userRepository;
    public TransactionResponse transaction(
            @NonNull TransactionRequest request
            ){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        var transaction = Transaction.builder()
                .amount(request.getAmount())
                .merchant(request.getMerchant())
                .category(request.getCategory())
                .location(request.getLocation())
                .user(user)
                .date(date)
                .build();
        repository.save(transaction);
        return TransactionResponse.builder()
                .message("Transaction success.")
                .build();
    }
}
