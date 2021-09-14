package com.outlook.me_litao.bean;

import java.util.List;

/**
 * @program: ssm-blog
 * @description: 通用的 DataPage 实现
 * @author: Ximu-Tao
 * @create: 2021-09-11 11:56
 **/
public class UniversalDataPage extends BaseDataPage{
    public List getList() {
        return super.list;
    }
    public static class UniversalDataPageFactory implements DataPageFactory{
        @Override
        public DataPage createDataPage() {
            return new UniversalDataPage();
        }
    }
    private static final UniversalDataPageFactory universalDataPageFactory = new UniversalDataPageFactory();

    public static DataPageFactory buildFactory(){
        return universalDataPageFactory;
    }
}
