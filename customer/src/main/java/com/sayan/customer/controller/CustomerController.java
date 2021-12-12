package com.sayan.customer.controller;

import com.sayan.customer.dto.CustomerRegisterRequest;
import com.sayan.customer.service.CustomerRegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerRegistrationService customerRegistrationService;

    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegisterRequest customerRegisterRequest){
        log.info("Inside registerCustomer controller method {}",customerRegisterRequest);
        customerRegistrationService.registerCustomer(customerRegisterRequest);
    }
}
