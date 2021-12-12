package com.sayan.customer.service;

import com.sayan.customer.dto.CustomerRegisterRequest;

public interface CustomerRegistrationService {
    void registerCustomer(CustomerRegisterRequest registerRequest);
}
