# API

## 全局响应状态码说明

| 字段值 | 说明 |
| ---  | --- |
| 200 | 正常 |
| 401 | 用户名不符合格式要求   |
| 402 | 用户名重复 |
| 403 | 找不到该用户 |
| 404 | 密码不是经过sha1加密的字符串 |
| 405 | 未登录 |
| 406 | 没有权限        |
| 407 | 缺少请求参数        |
| 408 | 文件大小超过限制         |
| 409 | 文件上传错误         |
| 410 | 文件类型错误         |
| 501 | 无法连接数据库 | 
| 502 | 无法修改数据库 |
| 503 | 查询到了多于1个用户 |
| 504 | 找不到目标数据 |

## 接口说明

### 查询博客

> 功能描述 : 使用指定条件分页查询博客

- Method: **GET** , **POST**
- URL:
  + ```/api/get/getbloglist.php```
  + ```/api/get/getbloglist```
- headers:
  + ```'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'```

#### 请求参数

> 使用 ```application/x-www-form-urlencoded;``` 方式传递参数

| 字段  | 字段类型  | 字段说明 | 必选项|
| --- | --- | --- | --- |
| find | String | 使用此字符串在标题和内容中进行模糊查找 | 否 |
| pid |  int | 查询指定 id 的用户发布的博客 | 否 |
| pdate | Date | 查询在指定日期内发布的博客 | 否 |
| page |  int | 分页 | 否(默认为1) |

#### 响应

> 响应为 JSON 格式

```json
{
  "code": 200,
  "msg": "OK",
  "data": {
    "bloglist": [
      {
        "avatar": "default.jpg",
        "content": "321",
        "id": "438",
        "name": "ximu",
        "publish_time": "2021-09-11T12:24:21",
        "publisher_id": "99",
        "title": "123"
      }
      //    , ...
    ],
    "pagenum": 1,
    "pagesnum": 13,
    "parameter": {}
  }
}
```

##### 响应说明(仅data部分)

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| bloglist | Array | [博客信息](#博客信息)列表 |
| pagenum | int | 当前页码 |
| pagesnum | int | 最页数 |

###### 博客信息

| 字段 | 类型 | 说明 |
| --- | --- | --- |
|id  | int | 博客的唯一ID |
|title | String | 博客标题 |
|content | String | 博客内容 |
|publish_time | String | 发布时间 |
|publisher_id | int | 发布人唯一ID |
|name | String | 发布人用户名 |
|avatar | String | 发布人头像在服务器的唯一ID |

### 头像上传

> 用户注册时上传头像

- Method: **GET** , **POST**
- URL:
  + ```/api/upload/avatar.php```
  + ```/api/upload/avatar```
- headers:
  + ```'Content-Type': 'multipart/form-data;```

#### 请求参数

> 使用 ```multipart/form-data;``` 方式传递文件

#### 响应

> 响应为 JSON 格式

```json
{
  "code": 200,
  "data": {
    "newname": "a3dc9a95-9be7-4f38-88aa-8ef2f0d46546"
  },
  "msg": "OK"
}
```

##### 响应说明(仅data部分)

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| newname | String | 头像文件在服务器的唯一标识 |
