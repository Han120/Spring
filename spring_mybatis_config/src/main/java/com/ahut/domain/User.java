package com.ahut.domain;

/**
 * @author hanzijian
 * @create 2020-06-26 8:46
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String pBirthday) {
        birthday = pBirthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
