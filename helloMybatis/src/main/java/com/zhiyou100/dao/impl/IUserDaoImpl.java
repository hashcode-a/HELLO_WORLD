package com.zhiyou100.dao.impl;

import com.zhiyou100.dao.IUserDao;
import com.zhiyou100.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> getAllUsers() {
        //JDBC原生步骤
        SqlSession session = factory.openSession();
        //session.se
        List<User> users = session.selectList("com.zhiyou100.dao.IUserDao.getAllUsers");
        return users;
    }
}
