package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 15:54
 **/
public class BlogDataPageFactory implements DataPageFactory{
    @Override
    public DataPage createDataPage() {
        return new BlogDataPage();
    }
}
