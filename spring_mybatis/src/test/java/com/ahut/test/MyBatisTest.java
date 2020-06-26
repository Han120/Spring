package com.ahut.test;

import com.ahut.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 9:06
 */
public class MyBatisTest {


    //查询
    @Test
    public void test() throws IOException {

        SqlSession sqlSession = getSqlSession();
        //执行操作,参数：namespace+id
        User userOne = sqlSession.selectOne("userMapper.findOne", 13);
        //测试
        System.out.println(userOne);

        //释放资源
        sqlSession.close();

    }
    //查询
    @Test
    public void test1() throws IOException {

        SqlSession sqlSession = getSqlSession();
        //执行操作,参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        //测试
        System.out.println(userList);

        //释放资源
        sqlSession.close();

    }

//    插入
    @Test
    public void test2() throws IOException {

        //模拟User对象
        User user=new User();
        user.setName("zhangran");
        user.setPassword("zr1234567");

        SqlSession sqlSession = getSqlSession();

        //执行操作,参数：namespace+id
        sqlSession.insert("userMapper.save",user);

//        //mybatis执行更新操作，要提交事务
//        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }
    //修改
    @Test
    public void test3() throws IOException {

        //模拟User对象
        User user=new User();
        user.setId(11);
        user.setName("hanzijian");
        SqlSession sqlSession = getSqlSession();

        //执行操作,参数：namespace+id
        sqlSession.update("userMapper.update",user);

//        //mybatis执行更新操作，要提交事务
//        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    //删除
    @Test
    public void test4() throws IOException {

        SqlSession sqlSession = getSqlSession();

        //执行操作,参数：namespace+id
       sqlSession.delete("userMapper.delete",9);

//        //mybatis执行更新操作，要提交事务
//        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }
    //删除
    @Test
    public void test5() throws IOException {


        SqlSession sqlSession = getSqlSession();

        //执行操作,参数：namespace+id
        sqlSession.delete("userMapper.delet","zhangran");

//        //mybatis执行更新操作，要提交事务
//        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    private SqlSession getSqlSession() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");

        //获取session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得Session会话对象
        return sqlSessionFactory.openSession(true);
    }
}
