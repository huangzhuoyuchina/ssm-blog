package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 17:21
 **/
@FunctionalInterface
public interface PackerFactory <T> {
    Packer<T> packing( T o );
}
