package com.ahut.aop;

/**
 * @author hanzijian
 * @create 2020-06-25 8:36
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i=1/0; 异常
        System.out.println("save runing...");
    }

}
