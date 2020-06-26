package com.ahut.demo;

import com.ahut.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hanzijian
 * @create 2020-06-22 15:09
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
