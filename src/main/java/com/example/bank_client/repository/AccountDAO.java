package com.example.bank_client.repository;

import com.example.bank_client.entity.Account;
import com.example.bank_client.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountDAO implements Dao<Account> {
    private Long accountId = 0L;
    private Customer customer;
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public boolean delete(Account account) {
        return accounts.removeIf(a -> a.getId() == account.getId());
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accounts.removeAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        for (Account account : entities) {
            save(account);
        }
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean deleteById(long id) {
        return accounts.removeIf(a -> a.getId() == id);
    }

    @Override
    public Account getOne(long id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
