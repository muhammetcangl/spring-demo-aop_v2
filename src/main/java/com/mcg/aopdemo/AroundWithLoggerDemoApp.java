package com.mcg.aopdemo;

import com.mcg.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main program: AroundDemoApp");

        logger.info("Calling getFortune");

        String data = trafficFortuneService.getFortune();

        logger.info("My fortune is: " + data);

        logger.info("Finished");

        // close the context
        context.close();
    }
}
