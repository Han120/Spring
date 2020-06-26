package com.ahut.proxy.cglib;

/**
 * @author hanzijian
 * @create 2020-06-25 8:36
 */
public class Advice {
    public void before(){
        System.out.println("前置增强. . . ");
    }
    public void afterReturning(){
        System.out.println("后置增强. . . ");
    }
}
