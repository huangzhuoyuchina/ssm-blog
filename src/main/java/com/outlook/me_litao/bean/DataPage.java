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
public interface DataPage <T> {

     String addParameter( String key , String value);

     void setPagenum(int pagenum);

     void setPagesnum(int pagesnum);

     void setList(List<T> list);


}
