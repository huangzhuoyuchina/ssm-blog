package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-11 11:10
 **/
public class BlogDataPage extends BaseDataPage{
    public List<Blog> getBloglist() {
        return super.list;
    }

    static private class BlogDataPageFactory implements DataPageFactory{
        @Override
        public DataPage createDataPage() {
            return new BlogDataPage();
        }
    }
    private static final BlogDataPageFactory blogDataPageFactory = new BlogDataPageFactory();

    public static DataPageFactory buildFactory(){
        return blogDataPageFactory;
    }

}
