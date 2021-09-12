package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 16:00
 **/
public abstract class BlogDataPageFactoryBuilder {
    private static final BlogDataPageFactory blogDataPageFactory = new BlogDataPageFactory();

    public static DataPageFactory build(){
        return blogDataPageFactory;
    }

}
