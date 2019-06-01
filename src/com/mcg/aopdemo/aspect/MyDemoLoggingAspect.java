package com.mcg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //#################################################################################
    // Bu ornekte ki asıl olay pointcut declaration yaparak aynı pointcuti kullanmak
    //#################################################################################

    @Pointcut("execution(* com.mcg.aopdemo.dao.*.*(..))")// in package in any class and any method
    private void forDaoPackage(){}


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("======>>> Executing @Before advice on addAccount()");

    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("======>>> Performing API analytics");

    }


}
