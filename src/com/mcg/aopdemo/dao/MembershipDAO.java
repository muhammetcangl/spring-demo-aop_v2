package com.mcg.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){

        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

    }

    // added method
    public void goToSleep(){

        System.out.println(getClass() + ": I'm going to sleep now...");
    }
}
