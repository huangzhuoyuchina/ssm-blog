package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.Blog;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 17:25
 **/
public class BlogPublicInfoPackerFactory implements PackerFactory<Blog>{
    @Override
    public BlogPublicInfo packing(Blog o) {
        return new BlogPublicInfo( o );
    }
}
