package com.sayan.fraud.controller;

import com.sayan.fraud.dto.FraudCheckResponse;
import com.sayan.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud")
@AllArgsConstructor
@Slf4j
public class FraudHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraud = fraudCheckHistoryService.isFraudulentCustomer(customerId);

        return ResponseEntity.ok(new FraudCheckResponse(isFraud));
    }
}
