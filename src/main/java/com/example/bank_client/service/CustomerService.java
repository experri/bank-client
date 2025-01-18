package com.example.bank_client.service;


import com.example.bank_client.entity.Customer;
import com.example.bank_client.repository.CustomerDAO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDAO.delete(customer);
    }

    public void deleteAllCustomers() {
        customerDAO.deleteAll(customerDAO.findAll());
    }

    public void saveAllCustomers(Customer customer) {
        customerDAO.saveAll(customerDAO.findAll());
    }

    public Customer getCustomer(Long id) {
        return (Customer) customerDAO.getOne(id);
    }

    public void deleteCustomer(Long id) {
        customerDAO.deleteById(id);
    }

}
