package com.ahut.service;

import com.ahut.dao.UserMapper;
import com.ahut.dao.impl.UserMapperImpl;
import com.ahut.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 11:34
 */
public class ServiceTest {
    public static void main(String[] args) throws IOException {
        //创建dao层对象,dao层实现手动编写的
        UserMapper userMapper=new UserMapperImpl();
        List<User> all=userMapper.findAll();

        System.out.println(all);
    }

}
