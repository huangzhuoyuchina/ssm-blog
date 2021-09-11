package com.outlook.me_litao.service;

import com.outlook.me_litao.bean.BaseDataPage;
import com.outlook.me_litao.bean.DataPage;
import com.outlook.me_litao.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-04 13:28
 **/
public interface BlogService {
    void addBlog( @Param("blog") Blog b);

    void delBlog( @Param("bid") int bid );

    DataPage selectBlogs(Map m);

    <T extends BaseDataPage> void setDataPageType(Class< T > c);

    int selectBlogsCount(Map m);
}
