package com.example.bank_client.service;


import com.example.bank_client.entity.Account;
import com.example.bank_client.entity.Currency;
import com.example.bank_client.entity.Customer;
import com.example.bank_client.repository.AccountDAO;
import com.example.bank_client.repository.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountDAO accountDAO;
    private final CustomerDAO customerDAO;


    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
        this.customerDAO = new CustomerDAO();
    }

    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    public  Account createAccount(Currency currency, long customerId) {
        Customer customer = customerDAO.getOne(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        Account account = new Account(currency, customer);
        return accountDAO.save(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);
    }

    public void deleteAllAccount(List<Account> accounts) {
        accountDAO.deleteAll(accounts);
    }

    public void saveAllAccount(List<Account> accounts) {
        accountDAO.saveAll(accounts);
    }

    public Optional<Account> getOneAccount(long id) {
        return Optional.ofNullable(accountDAO.getOne(id));
    }

    public boolean deleteById(long id) {
        return accountDAO.deleteById(id);
    }
}
