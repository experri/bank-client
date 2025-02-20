package com.example.bank_client.repository;

import com.example.bank_client.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAO implements Dao<Customer> {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public boolean delete(Customer customer) {
        return customers.removeIf(c -> c.getId() == customer.getId());
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customers.removeAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        for (Customer customer : entities) {
            save(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean deleteById(long id) {
        return customers.removeIf(c -> c.getId() == id);
    }

    @Override
    public Customer getOne(long id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}


