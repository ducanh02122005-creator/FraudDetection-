package com.example.frauddetection.service.transactionService;

import com.example.frauddetection.dtos.prediction.PredictionRequest;
import com.example.frauddetection.dtos.transaction.TransactionRequest;
import com.example.frauddetection.dtos.transaction.TransactionResponse;
import com.example.frauddetection.entity.prediction.FraudPrediction;
import com.example.frauddetection.entity.transaction.Transaction;
import com.example.frauddetection.entity.user.User;
import com.example.frauddetection.repository.predictionRepository.PredictionRepository;
import com.example.frauddetection.repository.transactionRepository.TransactionRepository;
import com.example.frauddetection.repository.userRepository.UserRepository;
import com.example.frauddetection.service.PredictionService.FraudDetectionService;
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
    private final FraudDetectionService fraudDetectionService;
    private final PredictionRepository predictionRepository;
    public TransactionResponse transaction(
            @NonNull TransactionRequest request
            ) throws Exception {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
        LocalDateTime date=LocalDateTime.now();
        var transHour = date.getHour();
        var prediction = PredictionRequest.builder()
                .transHour(transHour)
                .category(request.getCategory())
                .amount(request.getAmount())
                .build();


        Boolean fraud=fraudDetectionService.predict(prediction);
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
                .message(fraud ?
                        "Fraud detected" :
                        "Transaction accepted")
                .build();
    }
}
