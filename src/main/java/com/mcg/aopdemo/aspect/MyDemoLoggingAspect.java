package com.mcg.aopdemo.aspect;

import com.mcg.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.mcg.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out method we are advising on
        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("=========>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex){

            // log the exception
            logger.warning(ex.getMessage());

            // give user a custom message
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            // rethrow exception
            //throw ex;

        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        logger.info("=====>> Duration: "+ duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.mcg.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.mcg.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThhrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        logger.info("=========>>> The exception is: " + exception);
    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.mcg.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========>>> Executing @AfterRetuning on method: " + method);

        // print out the results of the method call
        logger.info("=========>>> result is :" + result);

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
        logger.info("======>>> Executing @Before advice on addAccount()");

        // display the method signature
        logger.info(joinPoint.getSignature().toString());

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            logger.info(arg.toString());

            if(arg instanceof Account){
                // downcast and print Accoun specific stuff
                Account account = (Account) arg;

                logger.info("account name: " + account.getName());
                logger.info("account level: " + account.getLevel());
            }
        }

    }

}
