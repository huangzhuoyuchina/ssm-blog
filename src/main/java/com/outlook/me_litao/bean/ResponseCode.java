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
    FILE_LARGE(408),
    FILE_UPLOAD_ERR(409),
    FILE_TYPE_ERR(410),
    DATABASE_CONNECT_ERR(501),
    DATABASE_ERR(502),
    QUERY_ERR(503),
    NOT_FIND_DATA(504);

    private final int c;
    ResponseCode( int code){
        this.c = code;
    }

    public int code() {
        return c;
    }
}