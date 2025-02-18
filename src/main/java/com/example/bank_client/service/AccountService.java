package com.example.bank_client.service;


import com.example.bank_client.entity.Account;
import com.example.bank_client.repository.AccountDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public List<Account> findAllAccounts() {
        return new ArrayList<>(accountDAO.findAll());
    }

    public Account saveAccount(Account account) {
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
