package com.mcg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    private static Logger logger = Logger.getLogger(MyApiAnalyticsAspect.class.getName());

    @Before("com.mcg.aopdemo.aspect.McgAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        logger.info("======>>> Performing API analytics");

    }

}
