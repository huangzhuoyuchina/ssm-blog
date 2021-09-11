package com.outlook.me_litao.controller;

import com.outlook.me_litao.bean.ResponseCode;
import com.outlook.me_litao.bean.ApiResponse;
import com.outlook.me_litao.bean.DataPage;
import com.outlook.me_litao.pojo.Blog;
import com.outlook.me_litao.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-06 14:32
 **/

@Controller
@RequestMapping("api")
@RestController
public class BlogController {

    @Autowired
    @Qualifier("blogServiceImpl")
    private BlogService blogService;

    @RequestMapping({"get/getbloglist.php" , "get/getbloglist" })
    public String getBlogs(
//            @RequestParam(name = "page", defaultValue = "1") String page,
//            @RequestParam(name = "find" ,required = false) String find,
//            @RequestParam(name = "publisher_id",required = false) String publisherId,
//            @RequestParam(name = "publish_time",required = false) String publishTime,
            @RequestParam Map<String,Object> params,
            Model m ){

//        System.out.println( page);
//        System.out.println( find);
//        System.out.println( publisherId);
//        System.out.println( publishTime);
        System.out.println(params);

        DataPage blogsPage = blogService.selectBlogs(params);
//        DataPage blogsPage = blogService.selectBlogs(null);

        ApiResponse result = new ApiResponse();
        result.setCode( ResponseCode.OK );
        result.setData( blogsPage );


        return result.toJSONString();
    }
}
