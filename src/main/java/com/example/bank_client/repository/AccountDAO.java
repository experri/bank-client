package com.example.bank_client.repository;

import com.example.bank_client.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccountDAO implements Dao<Account> {
    private final List<Account> accounts = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Account save(Account account) {
        account.setId(idGenerator.getAndIncrement());
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
        return new ArrayList<>(accounts);
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
