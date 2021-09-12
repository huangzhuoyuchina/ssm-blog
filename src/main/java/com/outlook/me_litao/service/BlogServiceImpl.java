package com.outlook.me_litao.service;


import com.outlook.me_litao.bean.*;
import com.outlook.me_litao.dao.BlogMapper;
import com.outlook.me_litao.pojo.Blog;
import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-06 12:18
 **/
public class BlogServiceImpl implements BlogService{
    private SqlSessionFactory sqlSessionFactory;
    private BlogMapper blogMapper;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.blogMapper = sqlSessionFactory.openSession().getMapper(BlogMapper.class);
    }

    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }



    @Override
    public void addBlog(Blog b) {
        blogMapper.addBlog(b);
    }

    @Override
    public void delBlog(int bid) {
        blogMapper.delBlog(bid);
    }
    private DataPageFactory dataPageFactory = UniversalDataPage.buildFactory();
    private PackerFactory<Blog> packerFactory = BlogPublicInfo.buildFactory();

    @Override
    public void setDataPageType(DataPageFactory dataPageFactory){
        this.dataPageFactory = dataPageFactory;
    }
    @Override
    public void setPackerType( PackerFactory packerFactory ){
        this.packerFactory = packerFactory;
    }

    @Override
    public DataPage selectBlogs(Map m ) {
        if ( m == null){
            m = new HashMap<String,Object>();
        }

        if ( !m.containsKey( "page") ){
            m.put("page" , "1" );
        }

        m.put("offSet" , 10 * ((Integer.parseInt((String) m.get("page")))-1 )  );
        m.put("limit" , 10 );

        int count  = blogMapper.selectBlogsCount( m );
        DataPage page = dataPageFactory.createDataPage();

        List<Blog> blogs2 = blogMapper.selectBlogs(m);

        List<Packer> blogs = blogs2.stream()
                .map(  blog -> packerFactory.packing( blog ))
                .collect(Collectors.toList());

        page.setList( blogs );
        page.setPagenum( Integer.parseInt((String) m.get("page")) );
        page.setPagesnum( (count/10)+ ((count%10)==0?0:1) );
        page.addParameter( "publisher_id" , (String) m.get("publisher_id"));

        page.addParameter("publish_time" , (String) m.get("publish_time"));

        packerFactory = BlogPublicInfo.buildFactory();
        return page;
    }

    @Override
    public int selectBlogsCount(Map m) {
        return blogMapper.selectBlogsCount(m);
    }
}
