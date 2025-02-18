package com.example.bank_client.service;


import com.example.bank_client.entity.Customer;
import com.example.bank_client.repository.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;
    private Long customerId = 0L;
    private final List<Customer> customers = new ArrayList<>();

    public CustomerService(CustomerDAO customerDao) {
        this.customerDAO = customerDao;
    }
    public Optional<Customer> getCustomerById(Long id) {
        return this.customers.stream().filter((customer ->  customer.getId().equals(id))).findFirst();
    }
    public List<Customer> addCustomer(Customer customer) {
        customerId++;
        customer.setId(customerId);
        this.customers.add(customer);
        return this.customers;
    }
    public List<Customer> getCustomers() {
        return this.customers;
    }

    public List<Customer> getAllCustomers() {
        return this.customers;
    }

    public Customer getCustomerById(long id) {
        return customerDAO.getOne(id);
    }

    public boolean removeCustomer(long id) {
        return customerDAO.deleteById(id);
    }
}

