package com.mcg.aopdemo;

import com.mcg.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

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
            System.out.println("Main program ... caught exception: " + ex);
        }
        // display the accounts
        System.out.println("Main Program: AfterThrowingDemoApp");
        System.out.println("-----");

        System.out.println(accounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
