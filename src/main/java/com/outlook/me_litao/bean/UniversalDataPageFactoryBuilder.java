package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 16:08
 **/
public class UniversalDataPageFactoryBuilder {
    private static final UniversalDataPageFactory universalDataPageFactory = new UniversalDataPageFactory();

    public static DataPageFactory build(){
        return universalDataPageFactory;
    }
}
