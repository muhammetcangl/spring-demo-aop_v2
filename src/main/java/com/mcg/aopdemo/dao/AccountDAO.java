package com.mcg.aopdemo.dao;

import com.mcg.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AccountDAO {

    private Logger logger = Logger.getLogger(getClass().getName());


    private String name;
    private String serviceCode;

    // add a new method : findAccounts()
    public List<Account> findAccounts(boolean tripWire){

        // for academic purpose ... simulate an exception
        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

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

        logger.info(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    // added method
    public boolean doWork(){

        logger.info(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        logger.info(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        logger.info(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        logger.info(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        logger.info(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
