package com.ahut.domain;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 8:46
 */
public class User {
    private int id;
    private String username;
    private String password;

    //描述当前用户存在哪些订单
    private List<Order> orderList;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String pUsername) {
        username = pUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> pOrderList) {
        orderList = pOrderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
