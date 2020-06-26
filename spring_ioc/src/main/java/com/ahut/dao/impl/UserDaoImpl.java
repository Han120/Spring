package com.ahut.dao.impl;

import com.ahut.dao.UserDao;
import com.ahut.dao.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author hanzijian
 * @create 2020-06-22 15:04
 */
public class UserDaoImpl implements UserDao {
    private String username;
    private int age;
    private List<String> mStringList;
    private Map<String, User> mUserMap;
    private Properties mProperties;

    public void setUsername(String pUsername) {
        username = pUsername;
    }

    public void setAge(int pAge) {
        age = pAge;
    }

    public void setStringList(List<String> pStringList) {
        mStringList = pStringList;
    }

    public void setUserMap(Map<String, User> pUserMap) {
        mUserMap = pUserMap;
    }

    public void setProperties(Properties pProperties) {
        mProperties = pProperties;
    }

    public void save() {
        System.out.println(username);
        System.out.println(age);
        System.out.println(mStringList);
        System.out.println(mUserMap);
        System.out.println(mProperties);
        System.out.println("save runing...");
    }
}
