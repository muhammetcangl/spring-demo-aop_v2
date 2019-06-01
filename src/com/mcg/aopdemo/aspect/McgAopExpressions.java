package com.mcg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class McgAopExpressions {

    @Pointcut("execution(* com.mcg.aopdemo.dao.*.*(..))")// in package in any class and any method
    public void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.mcg.aopdemo.dao.*.get*(..))")// in package all getter methods
    public void getter(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.mcg.aopdemo.dao.*.set*(..))")// in package all setter methods
    public void setter(){}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
