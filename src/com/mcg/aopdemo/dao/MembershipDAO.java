package com.mcg.aopdemo.dao;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MembershipDAO {

    private Logger logger = Logger.getLogger(getClass().getName());

    public void addAccount(){

        logger.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

    }

    // added method
    public void goToSleep(){

        logger.info(getClass() + ": I'm going to sleep now...");
    }
}
