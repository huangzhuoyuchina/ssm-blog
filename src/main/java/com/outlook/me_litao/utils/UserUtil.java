package com.outlook.me_litao.utils;

import java.util.regex.Pattern;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 16:08
 **/
public abstract class UserUtil {
    public static boolean checkName( String name){

        String pattern = "^[A-Za-z0-9_\\x{4e00}-\\x{9fa5}]+$";

        return Pattern.matches(pattern, name);
    }


    public static boolean checkPw( String pw ){
        return true;
    }
}
