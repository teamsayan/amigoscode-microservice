package com.sayan.customer.service;

import com.sayan.customer.dto.CustomerRegisterRequest;
import com.sayan.customer.dto.FraudCheckResponse;
import com.sayan.customer.model.Customer;
import com.sayan.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{

    private CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .build();

        Customer created = customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/{customerId}", FraudCheckResponse.class, created.getId());
        if (fraudCheckResponse.isFraud()) {
            throw new IllegalStateException("It is a fraudster");
        }
        log.info("Created Customer: {}",created.getId());
    }
}
