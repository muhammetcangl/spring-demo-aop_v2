package com.mcg.aopdemo.dao;

import com.mcg.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method : findAccounts()
    public List<Account> findAccounts(){

        List<Account> accounts = new ArrayList<>();

        // create sample accounts
        Account account1 = new Account("Muhammetcan", "gl");
        Account account2 = new Account("deneme1", "deneme1");
        Account account3 = new Account("deneme2", "deneme2");

        // add them to our accounts list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    // added parameter
    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    // added method
    public boolean doWork(){

        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
