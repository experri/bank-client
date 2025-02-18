package com.example.bank_client.controller;


import com.example.bank_client.entity.Account;
import com.example.bank_client.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public void findAllAccounts() {
        accountService.findAllAccounts();
    }

    @PostMapping("/save")
    public void saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @GetMapping("/delete")
    public void deleteAccount(Account account) {
        accountService.deleteAccount(account);
    }

    @GetMapping("/deleteById")
    public void deleteById(long id) {
        accountService.deleteById(id);
    }

    @GetMapping("/getOne")
    public void getOneAccount(long id) {
        accountService.getOneAccount(id);
    }

    @GetMapping("/saveAll")
    public void saveAllAccount(List<Account> accounts) {
        accountService.saveAllAccount(accounts);
    }

    @GetMapping("/deleteAll")
    public void deleteAllAccount(List<Account> accounts) {
        accountService.deleteAllAccount(accounts);
    }
}
