package com.ahut.dao.impl;

import com.ahut.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author hanzijian
 * @create 2020-06-22 15:04
 */
//<bean id="userDao" class="com.ahut.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Value("${jdbc.drive}")
    private String diver;
    public void save() {
        System.out.println(diver);
        System.out.println("save runing...");
    }
}
