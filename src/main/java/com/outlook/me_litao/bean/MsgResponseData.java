package com.outlook.me_litao.bean;

import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-13 18:36
 **/
public interface MsgResponseData extends ResponseData , Map<String,String> {
    default String addMsg( String name, String content){
        return this.put( name , content );
    }
}
