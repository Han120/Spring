package com.ahut.service.impl;

import com.ahut.dao.UserDao;
import com.ahut.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hanzijian
 * @create 2020-06-22 15:23
 */
//<bean id="userService" class="com.ahut.service.impl.UserServiceImpl"></bean>
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
//     <property name="userDao" ref="userDao"></property>
  /*  @Autowired   //按照数据类型从spring容器中进行匹配
    @Qualifier("userDao") //按照ID从spring容器中进行匹配的。此处需结合Autowired一起使用*/
    @Resource(name="userDao")//相当于Autowired+Qualifier
    private UserDao mUserDao;

  /*  //set注入
    public void setUserDao(UserDao pUserDao) {
        mUserDao = pUserDao;
    }*/
    public void save() {
        mUserDao.save();
    }
}
