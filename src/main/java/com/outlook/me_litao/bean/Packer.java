package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: POJO 对象的包装类
 * @author: Ximu-Tao
 * @create: 2021-09-12 15:51
 **/
public interface Packer<T> {
    void setObject( T o);
}
