package com.outlook.me_litao.bean;

public enum ResponseCode {

    OK(200),
    USERNAME_ERROR(401) ,
    USERNAME_REPEAT(402) ,
    USER_NOT_FOUND(403 ),
    PW_NOT_SHA1(404),
    NOT_LOGGED(405),
    NO_PERMISSION(406),
    MISSING_PARAMETER(407),
    FILE_LARGE(408);

    private final int c;
    ResponseCode( int code){
        this.c = code;
    }

    public int code() {
        return c;
    }
}

//| 409 | 文件上传错误         |
//| 410 | 文件类型错误         |
//| 501 | 无法连接数据库 |
//| 502 | 无法修改数据库 |
//| 503 | 查询到了多于1个用户 |
//| 504 | 找不到目标数据 |