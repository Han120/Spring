package com.ahut.mapper;

import com.ahut.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-28 8:41
 */
public interface RoleMapper {
    @Select("select *from sys_user_role ur,sys_role r where ur.roleid= r.id and ur.userid=#{uid}")
    public List<Role> findByUserId(int uid);
}
