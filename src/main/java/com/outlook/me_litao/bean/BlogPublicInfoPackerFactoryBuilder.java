package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.Blog;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 17:38
 **/
public class BlogPublicInfoPackerFactoryBuilder {
    private static PackerFactory<Blog> packerFactory = new BlogPublicInfoPackerFactory();
    public static PackerFactory<Blog> build(){
        return packerFactory;
    }
}
