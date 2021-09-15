package com.outlook.me_litao.dao;

import com.outlook.me_litao.pojo.User;

import java.util.List;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 14:51
 **/
public interface UserMapper {
    void addUser(User u);
    List<User> selectUser( User u);
}
