package com.outlook.me_litao.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-07 17:52
 **/
public class ApiResponse {
    private ResponseCode code;
    private ResponseData data;

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public int getCode() {
        return code.code();
    }
    public String getMsg() {
        return code.toString();
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }


    public String toJSONString(){
        return JSONObject.toJSONString( this );
    }
}
