package com.example.bank_client.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Customer {

    private static long idCounter = 0;
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private List<Account> accounts = new ArrayList<>();


    public Customer(){}

    public Customer(String name, String email, Integer age){
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
