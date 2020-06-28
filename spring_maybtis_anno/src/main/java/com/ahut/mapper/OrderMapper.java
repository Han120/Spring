package com.ahut.mapper;

import com.ahut.domain.Order;
import com.ahut.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-27 18:07
 */
public interface OrderMapper {
    //一对一
/*//    方法一
    @Select("SELECT *,o.id oid FROM orders o ,user u WHERE o.uid=u.id")
    @Results({
            @Result(column="oid",property="id"),
            @Result(column="ordertime",property="ordertime"),
            @Result(column="total",property="total"),
            @Result(column="uid", property="user.id"),
            @Result(column="username" ,property="user.username"),
            @Result(column="password", property="user.password")
    })
    public List<Order> findAll();*/
    //方法二
    @Select("SELECT * FROM orders")
    @Results({
            @Result(column="id",property="id"),
            @Result(column="ordertime",property="ordertime"),
            @Result(column="total",property="total"),
           @Result(
                   property = "user",//要封装的属性名称
                   column = "uid",//根据哪个属性去查user表数据（外键）
                   javaType = User.class,//要封装的实体类型
                   one=@One(select = "com.ahut.mapper.UserMapper.findOne")


           )
    })
    public List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    public List<Order>findOne(int uid);
}
