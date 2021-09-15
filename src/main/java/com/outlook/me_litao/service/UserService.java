package com.outlook.me_litao.service;

import com.outlook.me_litao.pojo.User;

import java.util.List;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 15:10
 **/
public interface UserService {
    void addUser(User u);
    List<User> selectUser(User u);
    User getUserById( int id);
}
