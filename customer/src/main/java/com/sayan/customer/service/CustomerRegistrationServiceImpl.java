package com.sayan.customer.service;

import com.sayan.customer.dto.CustomerRegisterRequest;
import com.sayan.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{
    @Override
    public void registerCustomer(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .build();
    }
}
