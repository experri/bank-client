package com.example.bank_client.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private List<Account> accounts;


    public Customer(String name, String email, Integer age){
        UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
