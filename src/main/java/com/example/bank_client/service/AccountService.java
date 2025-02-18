package com.example.bank_client.service;


import com.example.bank_client.entity.Account;
import com.example.bank_client.entity.Customer;
import com.example.bank_client.repository.AccountDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private Long accountId = 0L;
    private final AccountDAO accountDAO;
    private final List<Account> accounts = new ArrayList<>();

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public List<Account> getAllAccounts() {
        return this.accounts;
    }
    public List<Account> addAccount(Account account) {
        accountId++;
        account.setId(accountId);
        this.accounts.add(account);
        return this.accounts;
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
