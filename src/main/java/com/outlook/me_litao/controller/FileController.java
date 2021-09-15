package com.outlook.me_litao.controller;

import com.outlook.me_litao.bean.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @program: ssm-blog
 * @description: description
 * @author: Ximu-Tao
 * @create: 2021-09-13 18:30
 **/

@RestController
public class FileController {
    @RequestMapping({"api/upload/avatar.php" , "api/upload/avatar" })
    public String uploadAvatar(
            HttpServletRequest request, @RequestParam("avatar") CommonsMultipartFile avatar ){
        ApiResponse result = (ApiResponse) request.getAttribute("apiResponse");

        String avatarName = avatar.getOriginalFilename();

        if ( "".equals(avatarName) ){
            result.setCode( ResponseCode.FILE_UPLOAD_ERR );
            return result.toJSONString();
        }

        System.out.println( "上传的文件名" + avatarName );

        long size = avatar.getSize();
        System.out.println( "文件大小" + size );
        if ( size > 1000000 || size < 0 ){
            result.setCode( ResponseCode.FILE_LARGE );
            return result.toJSONString();
        }

        String path = request.getSession().getServletContext().getRealPath("/upload/avatar");
        File realPath = new File(path);
        if ( !realPath.exists() ){
            realPath.mkdirs();
        }

        System.out.println( "上传文件保存位置" + realPath );
        String newAvatarName = UUID.randomUUID().toString();
        try {

            avatar.transferTo( new File( realPath , newAvatarName ) );
            HashMsgResponseData map = new HashMsgResponseData();
            map.put("newname" , newAvatarName );
            result.setData( map );

        } catch (IOException e) {
            result.setCode( ResponseCode.FILE_UPLOAD_ERR );
            e.printStackTrace();
            return result.toJSONString();
        }

        return result.toJSONString();
    }

    @RequestMapping("upload/avatar/{avatarName}" )
    public void getAvatar(
            @PathVariable String avatarName,
            HttpServletRequest request, ServletResponse response
    ){

        String path = request.getSession().getServletContext().getRealPath("/upload/avatar");
//        ;
        File file =  new File( path , avatarName );
//        System.out.println( file );
        try (
                OutputStream os = response.getOutputStream();
                InputStream bis = new FileInputStream( file );
        ){
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
        }

    }

}
