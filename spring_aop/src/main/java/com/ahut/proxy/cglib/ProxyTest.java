package com.ahut.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hanzijian
 * @create 2020-06-25 8:38
 */
public class ProxyTest {
    public static void main(String[] args) {
        //获得目标对象
       final Target target=new Target();//目标对象

        //获得增强对象
       final   Advice advice=new Advice();//增强对象

        //返回值就是动态生成的代理对象 基于cglib
/*1. 创建增强器*/
        Enhancer enhancer=new Enhancer();

/*2. 设置父类(目标)*/
        enhancer.setSuperclass(com.ahut.proxy.cglib.Target.class);

/*3. 设置回调*/
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy pMethodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterReturning();//执行后置
                return invoke;
            }
        });
/*4. 创建代理对象*/
        com.ahut.proxy.cglib.Target  proxy = (com.ahut.proxy.cglib.Target) enhancer.create();

        proxy.save();
    }
}
