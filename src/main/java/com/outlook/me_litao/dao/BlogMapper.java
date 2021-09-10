package com.outlook.me_litao.dao;

import com.outlook.me_litao.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-04 10:20
 **/
public interface BlogMapper {
    void addBlog( @Param("blog")  Blog b);

    void delBlog( @Param("bid") int bid );


    /**
     * 根据 Map 内的条件查询博客
     * Map 内参数:
     *       bid : int , 博客ID , 可选
     *       find : String , 使用此字符串在标题和内容中进行模糊查找 , 可选
     *       pid : int , 发布人ID , 可选
     *       pdate : date , 发布日期 , 可选
     *       offSet : int , 必要
     *       limit : int , 必要
     * @param m
     * @return
     */
    List<Blog> selectBlogs(Map m);
    int selectBlogsCount(Map m);

}
