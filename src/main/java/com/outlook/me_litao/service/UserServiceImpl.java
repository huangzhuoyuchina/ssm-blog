package com.outlook.me_litao.service;

import com.outlook.me_litao.dao.BlogMapper;
import com.outlook.me_litao.dao.UserMapper;
import com.outlook.me_litao.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 15:12
 **/
public class UserServiceImpl implements UserService{

    private SqlSessionFactory sqlSessionFactory;
    private UserMapper userMapper;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
    }

    @Override
    public void addUser(User u) {
        userMapper.addUser( u );
    }

    @Override
    public List<User> selectUser(User u) {
        return userMapper.selectUser( u );
    }

    @Override
    public User getUserById( int id){
        return userMapper.getUserById( id );
    }
}
