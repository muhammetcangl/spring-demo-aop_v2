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
    //
    // Son guncelleme ile pointcutlari logic operatorler ile combine ettik.
    //
    //#################################################################################

    @Pointcut("execution(* com.mcg.aopdemo.dao.*.*(..))")// in package in any class and any method
    private void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.mcg.aopdemo.dao.*.get*(..))")// in package all getter methods
    private void getter(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.mcg.aopdemo.dao.*.set*(..))")// in package all setter methods
    private void setter(){}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("======>>> Executing @Before advice on addAccount()");

    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("======>>> Performing API analytics");

    }


}
