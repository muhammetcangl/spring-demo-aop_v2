package com.mcg.aopdemo.aspect;

import com.mcg.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.mcg.aopdemo.aspect.McgAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("======>>> Executing @Before advice on addAccount()");

        // display the method signature
        System.out.println(joinPoint.getSignature());

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            System.out.println(arg);

            if(arg instanceof Account){
                // downcast and print Accoun specific stuff
                Account account = (Account) arg;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }

}
