package com.ahut.mapper;

import com.ahut.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 15:36
 */
public interface UserMapper {
    @Select("select * from user")
    public List<User> findAll();
    @Select("select * from user where id=#{id}")
    public User findOne(int id);
    @Insert("insert into user values(#{id},#{name},#{password})")
    public void save(User user);
    @Update("update user set name=#{name} where id=#{id}")
    public void update(User user);
    @Delete("delete from user where id=#{id}")
    public void delete(int id);


    //1对多
    @Select("select * from user")
    @Results({
            @Result(id=true,column="uid", property="id"),
            @Result(column="username", property="username"),
            @Result(column="password" ,property="password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.ahut.mapper.OrderMapper.findOne")
            )}

    )
    public List<User> findOrders();




    //多对多
    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    column = "id",
                    property = "roleList",
                    javaType = List.class,
                    many=@Many(select ="com.ahut.mapper.RoleMapper.findByUserId" )
            )
    })
    public List<User> findRoles();
}
