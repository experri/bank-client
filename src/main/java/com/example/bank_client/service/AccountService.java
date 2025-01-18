package com.example.bank_client.service;


import com.example.bank_client.entity.Account;
import com.example.bank_client.repository.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void saveAccount(Account account) {
        accountDAO.save(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);
    }

    public void findAllAccounts() {
        accountDAO.findAll();
    }

    public void deleteAllAccounts() {
        accountDAO.deleteAll(accountDAO.findAll());
    }

    public void saveAllAccounts (Account account) {
        accountDAO.saveAll(accountDAO.findAll());
    }

    public Account getAccount(Long id) {
        return (Account) accountDAO.getOne(id);
    }

    public boolean deleteAccount(Long id) {
        return accountDAO.deleteById(id);
    }

}
