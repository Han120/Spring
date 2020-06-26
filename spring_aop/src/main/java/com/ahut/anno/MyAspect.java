package com.ahut.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author hanzijian
 * @create 2020-06-25 9:33
 */
@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    @Before(value = "execution(public void com.ahut.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }

    @AfterReturning("myPointcut()")
    public void afterRuning(){
        System.out.println("后置增强...");
    }

    @Around("MyAspect.myPointcut()")
    public Object round(ProceedingJoinPoint pJoinPoint) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = pJoinPoint.proceed();//切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    @AfterThrowing("myPointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }

    @After("myPointcut()")
    public void after(){
        System.out.println("最终增强...");
    }

    @Pointcut("execution(public void com.ahut.anno.*.*(..))")
    public void myPointcut(){
    }
}
