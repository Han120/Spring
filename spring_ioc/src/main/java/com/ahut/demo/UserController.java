package com.ahut.demo;

import com.ahut.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hanzijian
 * @create 2020-06-22 15:27
 */
public class UserController {
    public static void main(String[] args) {
//        UserService userService=new UserServiceImpl();
//        userService.save();
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService= (UserService) applicationContext.getBean("userService");
        UserService userService=applicationContext.getBean(UserService.class);
        userService.save();

    }
}
