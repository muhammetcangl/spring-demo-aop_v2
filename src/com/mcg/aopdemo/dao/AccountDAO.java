package com.mcg.aopdemo.dao;

import com.mcg.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    // added parameter
    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    // added method
    public boolean doWork(){

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
