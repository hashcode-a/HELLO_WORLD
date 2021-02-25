package com.zhiyou100.test;

import com.zhiyou100.dao.IUserDao;
import com.zhiyou100.dao.impl.IUserDaoImpl;
import com.zhiyou100.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


//测试mybatis配置信息
public class UserTest {

    @Test
    public void testGetAllUser() throws Exception {
        // 加载mybatis的核心配置对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory是一个接口,不能直接new创建对象
        //借助于构建者类SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        //通过构建者类的build方法来构建工厂对象
        SqlSessionFactory factory = sfb.build(is);
        //通过工厂对象创建SQLSession
        SqlSession sqlSession = factory.openSession();
        // 通过getMapper方法
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        // 有了IUserDao的实现类对象
        List<User> users = mapper.getAllUsers();
        for (User u:users
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void testGetAllUsers2() throws IOException {
        // 加载mybatis的核心配置对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory是一个接口,不能直接new创建对象
        //借助于构建者类SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        //通过构建者类的build方法来构建工厂对象
        SqlSessionFactory factory = sfb.build(is);
        // 实例化接口实现类对象
        IUserDaoImpl userDao = new IUserDaoImpl(factory);
        List<User> users = userDao.getAllUsers();
        for(User user:users){
            System.out.println(user);
        }
    }

}
