package com.outlook.me_litao.bean;

import com.outlook.me_litao.pojo.Blog;

/**
 * @program: ssm-blog
 * @description: Blog 的包装类, 仅对外暴露可被公开的信息
 * @author: Ximu-Tao
 * @create: 2021-09-12 16:38
 **/
public class BlogPublicInfo implements Packer <Blog>{
    private Blog blog;
    public BlogPublicInfo( Blog blog){
        this.blog = blog;
    }

    public String getId(){
        return String.valueOf(blog.getId());
    }

    public String getAvatar(){
        return blog.getPublisher().getAvatar();
    }

    public String getName(){
        return blog.getPublisher().getName();
    }

    public String getPublish_time(){
        return blog.getPublishTime().toString();
    }

    public String getPublisher_id(){
        return String.valueOf(blog.getPublisher().getId());
    }

    public String getTitle(){
        return blog.getTitle();
    }

    public String getContent(){
        return blog.getContent();
    }

    @Override
    public void setObject(Blog o) {
        this.blog = o;
    }

    static private class BlogPublicInfoPackerFactory implements PackerFactory<Blog>{
        @Override
        public BlogPublicInfo packing(Blog o) {
            return new BlogPublicInfo( o );
        }

        }

    private static PackerFactory<Blog> packerFactory = new BlogPublicInfoPackerFactory();
    public static PackerFactory<Blog> buildFactory(){
        return packerFactory;
    }

}
