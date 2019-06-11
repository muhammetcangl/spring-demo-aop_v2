package com.mcg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    private Logger logger = Logger.getLogger(getClass().getName());


    @Before("com.mcg.aopdemo.aspect.McgAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        logger.info("======>>> Logging to Cloud in async fashion");

    }
}
