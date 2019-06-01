package com.mcg.aopdemo.aspect;

import com.mcg.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.mcg.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=========>>> Executing @AfterRetuning on method: " + method);

        // print out the results of the method call
        System.out.println("=========>>> result is :" + result);

        //let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for(Account account: result){

            // get uppercase version of name
            String upperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperName);
        }

    }

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
