package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: 基本的的 DataPage 实现, 只负责 DataPage 的通用部分
 * @author: Ximu-Tao
 * @create: 2021-09-11 11:37
 **/
public abstract class BaseDataPage <T> extends DataPageAdapter <T> {
    public Map<String, String> getParameter() {
        return parameter;
    }
    public int getPagenum() {
        return pagenum;
    }
    public int getPagesnum() {
        return pagesnum;
    }
}
