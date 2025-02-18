package com.example.bank_client.controller;


import com.example.bank_client.entity.Customer;
import com.example.bank_client.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public List<Customer> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    public Customer findCustomerById(long id) {
        return customerService.getCustomerById(id);
    }

    public boolean deleteCustomer(long id) {
        return customerService.removeCustomer(id);
    }
}

