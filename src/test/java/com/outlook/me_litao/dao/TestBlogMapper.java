package com.outlook.me_litao.dao;

import com.outlook.me_litao.pojo.Blog;
import com.outlook.me_litao.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-04 10:47
 **/
public class TestBlogMapper {
    private ApplicationContext context;
    private BlogMapper userMapper;

    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userMapper = context.getBean("sqlSessionFactory" , SqlSessionFactory.class ).openSession().getMapper(BlogMapper.class);
    }

    @Test
    public void testAddBlog(){
        Blog blog = new Blog();
        User user = new User();
        user.setId(20);
        blog.setPublisher( user );
        blog.setTitle("Hello");
        blog.setContent("Hio Hello SSM");
        userMapper.addBlog( blog );
    }

    @Test
    public void testDelBlog(){
        userMapper.delBlog(434);
    }

    @Test
    public void selectBlogs1(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("offSet" , 10);
        map.put("limit" , 10);

        List<Blog> blogs = userMapper.selectBlogs(map);
        blogs.forEach(System.out::println);
    }



    @Test
    public void selectBlogs2(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("find" , "Hello");
        map.put("offSet" , 0);
        map.put("limit" , 10);

        List<Blog> blogs = userMapper.selectBlogs(map);
        blogs.forEach(System.out::println);
        System.out.println(userMapper.selectBlogsCount(map));
    }




}
