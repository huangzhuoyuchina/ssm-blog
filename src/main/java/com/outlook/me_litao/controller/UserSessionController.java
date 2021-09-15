package com.outlook.me_litao.controller;

import com.outlook.me_litao.bean.ApiResponse;
import com.outlook.me_litao.bean.DataPageFactory;
import com.outlook.me_litao.bean.ResponseCode;
import com.outlook.me_litao.bean.UserPublicInfo;
import com.outlook.me_litao.pojo.User;
import com.outlook.me_litao.service.BlogService;
import com.outlook.me_litao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-15 13:13
 **/

@Controller
@RequestMapping("api")
@RestController
public class UserSessionController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping({"login.php" , "login" })
    public String login( @RequestParam("uname") String uname,
                         @RequestParam("upw") String upw,
                         HttpServletRequest request ){
//      TODO :   正则表达式测试用户名
//        TODO : 检查密码是否已被加密
        ApiResponse result = (ApiResponse) request.getAttribute("apiResponse");
        User user = new User();
        user.setPw( upw );
        user.setName( uname );

        List<User> users = userService.selectUser(user);

        if ( users.size() != 1 ){
            result.setCode( ResponseCode.USER_NOT_FOUND );
        }else {
            request.getSession().setAttribute( "user" , users.get(0) );
        }

        return result.toJSONString();
    }

    @RequestMapping({"unlog.php" , "unlog" })
    public String unlog( HttpServletRequest request ){

        ApiResponse result = (ApiResponse) request.getAttribute("apiResponse");

        request.getSession().removeAttribute( "user" );

        return result.toJSONString();
    }



    @RequestMapping({"get/getuserdata.php" , "get/getuserdata" })
    public String getUserData(@RequestParam( value = "id" , required = false ) Integer id,
                              HttpServletRequest request, HttpServletResponse response ){
        ApiResponse result = (ApiResponse) request.getAttribute("apiResponse");
//        System.out.println( "getuserdata" +  id );
        Object user = request.getSession().getAttribute("user");
        System.out.println( user );
        if ( user==null ){
            result.setCode( ResponseCode.NOT_LOGGED );
            return result.toJSONString();
        }

        if ( id != null ){
            user = userService.getUserById( id );
        }

        UserPublicInfo userPublicInfo = new UserPublicInfo();
        userPublicInfo.setUser(  (User)user );
        result.setData( userPublicInfo );

        return result.toJSONString();

    }

}
