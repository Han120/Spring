package com.ahut.proxy.jdk;

/**
 * @author hanzijian
 * @create 2020-06-25 8:36
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save runing...");
    }

}
