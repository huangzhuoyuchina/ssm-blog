package com.outlook.me_litao.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-07 17:57
 **/
public class  DataPage <T> {
    private int pagenum;
    private int pagesnum;
    private List<T> list;
    private final Map<String,String> parameter = new HashMap<>();

    public String addParameter( String key , String value){
        return parameter.put(key, value);
    }

    public Map<String, String> getParameter() {
        return parameter;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesnum() {
        return pagesnum;
    }

    public void setPagesnum(int pagesnum) {
        this.pagesnum = pagesnum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }



    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean add(T o) {
        return list.add(o);
    }

    public boolean addAll(List<T> l) {
        return list.addAll(l);
    }


    public void clear() {
        list.clear();
    }


}
