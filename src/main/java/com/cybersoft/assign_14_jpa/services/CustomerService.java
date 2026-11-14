package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> getAllCustomers();
}
