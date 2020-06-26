package com.ahut.anno;

import org.springframework.stereotype.Component;

/**
 * @author hanzijian
 * @create 2020-06-25 8:36
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i=1/0; 异常
        System.out.println("save runing...");
    }

}
