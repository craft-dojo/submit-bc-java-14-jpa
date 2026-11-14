package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getCustomers() {
        BaseResponse res = BaseResponse.success(customerService.getAllCustomers(), null, null);

        return ResponseEntity.ok(res);
    }
}
