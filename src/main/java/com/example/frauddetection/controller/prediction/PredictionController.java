package com.example.frauddetection.controller.prediction;

import com.example.frauddetection.dtos.prediction.PredictionRequest;
import com.example.frauddetection.dtos.prediction.PredictionResponse;
import com.example.frauddetection.service.PredictionService.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prediction")
@RequiredArgsConstructor
public class PredictionController {

    private final FraudDetectionService service;

    @PostMapping
    public ResponseEntity<Boolean> predict(
            @RequestBody PredictionRequest request
    ) throws Exception {

        return ResponseEntity.ok(
                service.predict(request)
        );
    }
}
