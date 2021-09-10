package com.outlook.me_litao.service;

import com.outlook.me_litao.bean.DataPage;
import com.outlook.me_litao.pojo.Blog;
import com.outlook.me_litao.pojo.User;

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
 * @create: 2021-09-06 12:22
 **/
public class TestBlogService {
    private ApplicationContext context;
    private BlogService blogService;

    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.blogService = context.getBean("blogServiceImpl" , BlogServiceImpl.class );
    }

    @Test
    public void testAddBlog(){
        Blog blog = new Blog();
        User user = new User();
        user.setId(20);
        blog.setPublisher( user );
        blog.setTitle("Hello");
        blog.setContent("Hio Hello SSM");
        blogService.addBlog( blog );
    }

    @Test
    public void testDelBlog(){
        blogService.delBlog(437 );
    }

    @Test
    public void selectBlogs1(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("offSet" , 10);
        map.put("limit" , 10);

        DataPage blogs = blogService.selectBlogs(map);
        blogs.getList().forEach(System.out::println);
        System.out.println( blogs.getPagenum() );
        System.out.println( blogs.getPagesnum() );
    }



    @Test
    public void selectBlogs2(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("find" , "Hello");
        map.put("offSet" , 0);
        map.put("limit" , 10);

        DataPage blogs = blogService.selectBlogs(map);
        blogs.getList().forEach(System.out::println);
        System.out.println( blogs.getPagenum() );
        System.out.println( blogs.getPagesnum() );
    }
}

