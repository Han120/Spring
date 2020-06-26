package com.ahut.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author hanzijian
 * @create 2020-06-25 9:33
 */
public class MyAspect {
    public void before(){
        System.out.println("前置增强...");
    }
    public void afterRuning(){
        System.out.println("后置增强...");
    }
    public Object round(ProceedingJoinPoint pJoinPoint) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = pJoinPoint.proceed();//切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }
    public void after(){
        System.out.println("最终增强...");
    }
}
