package com.example.frauddetection.controller.transaction;

import com.example.frauddetection.dtos.transaction.TransactionRequest;
import com.example.frauddetection.dtos.transaction.TransactionResponse;
import com.example.frauddetection.service.transactionService.CreateTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final CreateTransactionService service;
    @PostMapping("/transacting")
    public ResponseEntity<TransactionResponse> transacting(
            @RequestBody TransactionRequest request
            )
    {
        return ResponseEntity.ok(service.transaction(request));
    }
}
