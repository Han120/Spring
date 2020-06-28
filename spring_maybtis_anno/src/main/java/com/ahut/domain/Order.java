package com.ahut.domain;

import java.util.Date;

/**
 * @author hanzijian
 * @create 2020-06-27 8:31
 */
public class Order {
    private int id;
    private Date ordertime;
    private double total;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date pOrdertime) {
        ordertime = pOrdertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double pTotal) {
        total = pTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User pUser) {
        user = pUser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
