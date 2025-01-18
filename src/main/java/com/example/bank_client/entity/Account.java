package com.example.bank_client.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Currency currency;
    private Double balance = 0.00;
    private Customer customer;

    public enum Currency {
        UAH,
        USD,
        EUR,
        CHF,
        GBP
    }

    public Account(Currency currency, Customer customer){
        UUID.randomUUID().toString();
        this.currency = currency;
        this.customer = customer;
    }

}