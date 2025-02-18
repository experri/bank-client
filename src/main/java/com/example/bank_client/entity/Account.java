package com.example.bank_client.entity;


import java.util.UUID;

public class Account {
    private Long id;
    private String number;
    private Currency currency;
    private Double balance = 0.00;
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public enum Currency {
        UAH,
        USD,
        EUR,
        CHF,
        GBP
    }

    public Account(Long id, Currency currency, Customer customer){
        this.id = id;
        this.number = UUID.randomUUID().toString();
        this.currency = currency;
        this.customer = customer;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Сума депозиту повинна бути більше нуля.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостатньо коштів або сума зняття некоректна.");
        }
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + number + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }
}