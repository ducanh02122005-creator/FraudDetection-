package com.example.frauddetection.service.PredictionService;

import com.example.frauddetection.dtos.prediction.PredictionRequest;
import com.example.frauddetection.dtos.prediction.PredictionResponse;
import com.example.frauddetection.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {

    private final OnnxPredictionService onnxService;
    private final CategoryMapper categoryMapper;

    public PredictionResponse predict(
            PredictionRequest request
    ) throws Exception {

        float amtLog =
                (float)Math.log(request.getAmount());

        int categoryIdx =
                categoryMapper.getIndex(
                        request.getCategory()
                );

        float logit =
                onnxService.predict(
                        request.getTransHour(),
                        categoryIdx,
                        amtLog
                );

        double probability =
                1.0 /
                        (1.0 + Math.exp(-logit));

        return PredictionResponse.builder()
                .fraudProbability(probability)
                .fraud(probability > 0.5)
                .build();
    }
}
