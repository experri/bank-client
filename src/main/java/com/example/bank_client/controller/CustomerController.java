package com.example.bank_client.controller;


import com.example.bank_client.entity.Customer;
import com.example.bank_client.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer.getName(), customer.getEmail(), customer.getAge());
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(long id) {
        return customerService.getCustomerById(id);
    }


    public boolean deleteCustomer(long id) {
        return customerService.removeCustomer(id);
    }
}

