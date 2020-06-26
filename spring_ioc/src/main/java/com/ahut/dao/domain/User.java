package com.ahut.dao.domain;

/**
 * @author hanzijian
 * @create 2020-06-22 16:16
 */
public class User {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String pAddr) {
        addr = pAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
