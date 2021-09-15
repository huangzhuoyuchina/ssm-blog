package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.User;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 15:28
 **/
public class UserPublicInfo implements ResponseData{
    private User user;
    public void setUser( User u){
        this.user = u;
    }

    public int getId() {
        return user.getId();
    }


    public String getName() {
        return user.getName();
    }

    public int getAuthority() {
        return user.getAuthority();
    }


    public String getAvatar() {
        return user.getAvatar();
    }

}
