package com.outlook.me_litao.bean;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-12 16:07
 **/
public class UniversalDataPageFactory implements DataPageFactory{
    @Override
    public DataPage createDataPage() {
        return new UniversalDataPage();
    }
    private static final UniversalDataPageFactory universalDataPageFactory = new UniversalDataPageFactory();

    public static DataPageFactory buildFactory(){
        return universalDataPageFactory;
    }

}
