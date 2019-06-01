package com.mcg.aopdemo;

import com.mcg.aopdemo.dao.AccountDAO;
import com.mcg.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = accountDAO.findAccounts();

        // display the accounts
        System.out.println("Main Program: AfterReturningDemoApp");
        System.out.println("-----");

        System.out.println(accounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
