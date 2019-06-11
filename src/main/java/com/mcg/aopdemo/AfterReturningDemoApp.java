package com.mcg.aopdemo;

import com.mcg.aopdemo.dao.AccountDAO;
import com.mcg.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AfterReturningDemoApp {

    private static Logger logger = Logger.getLogger(AfterReturningDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = accountDAO.findAccounts(false);

        // display the accounts
        logger.info("Main Program: AfterReturningDemoApp");
        logger.info("-----");

        logger.info(accounts.toString());
        logger.info("\n");

        // close the context
        context.close();
    }
}
