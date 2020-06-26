package com.ahut.domain;

/**
 * @author hanzijian
 * @create 2020-06-25 15:50
 */
public class User {
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pUsername) {
        name = pUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
