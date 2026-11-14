package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.repository.CustomerRepository;
import com.cybersoft.assign_14_jpa.response.CustomerResponseDTO;
import com.cybersoft.assign_14_jpa.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerResponseDTO::mapToDTO)
                .toList();
    }
}
