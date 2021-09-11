package com.outlook.me_litao.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: 抽象的 DataPage 实现, 只负责接受的存储数据, 如何被获取由子类决定
 * @author: Ximu-Tao
 * @create: 2021-09-07 17:57
 **/
public abstract class DataPageAdapter <T> implements DataPage{
    protected int pagenum;
    protected int pagesnum;
    protected List<T> list;
    protected final Map<String, String> parameter = new HashMap<>();

    @Override
    public String addParameter( String key , String value){
        return parameter.put(key, value);
    }

    @Override
    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    @Override
    public void setPagesnum(int pagesnum) {
        this.pagesnum = pagesnum;
    }

    @Override
    public void setList(List list) {
        this.list = list;
    }
}
