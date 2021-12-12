package com.sayan.customer.service;

import com.sayan.customer.dto.CustomerRegisterRequest;
import com.sayan.customer.model.Customer;
import com.sayan.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{

    private CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .build();

        Customer created = customerRepository.save(customer);
        log.info("Created Customer: {}",created.getId());
    }
}
