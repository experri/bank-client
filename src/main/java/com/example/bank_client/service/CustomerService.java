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

    public CustomerService(CustomerDAO customerDao) {
        this.customerDAO = customerDao;
    }

    public Customer createCustomer(String name, String email, Integer age) {
        Customer customer = new Customer(name, email, age);
        return customerDAO.save(customer);
    }


    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerDAO.getOne(id);
    }

    public boolean removeCustomer(long id) {
        return customerDAO.deleteById(id);
    }
}

