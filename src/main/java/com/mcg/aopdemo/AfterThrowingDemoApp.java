package com.mcg.aopdemo;

import com.mcg.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AfterThrowingDemoApp {

    private static Logger logger = Logger.getLogger(AfterThrowingDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simulate exception
            boolean tripWire = true;
            accountDAO.findAccounts(tripWire);
        } catch (Exception ex){
            logger.info("Main program ... caught exception: " + ex);
        }
        // display the accounts
        logger.info("Main Program: AfterThrowingDemoApp");
        logger.info("-----");

        logger.info(accounts.toString());
        logger.info("\n");

        // close the context
        context.close();
    }
}
