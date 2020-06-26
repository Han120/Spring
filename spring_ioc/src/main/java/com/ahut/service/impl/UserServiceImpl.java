package com.ahut.service.impl;

import com.ahut.dao.UserDao;
import com.ahut.service.UserService;

/**
 * @author hanzijian
 * @create 2020-06-22 15:23
 */
public class UserServiceImpl implements UserService {
    private UserDao mUserDao;


    //    无参构造
    public UserServiceImpl(){

    }
//    有参构造
    public UserServiceImpl(UserDao pUserDao)
    {
        mUserDao=pUserDao;
    }
   /* //set注入
    public void setUserDao(UserDao pUserDao) {
        mUserDao = pUserDao;
    }
*/
    public void save() {
        mUserDao.save();
    }
}
