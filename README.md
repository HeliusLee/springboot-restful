# RESTful

## 0. 参考资料

1.[阮一峰.理解RESTful 架构]: http://www.ruanyifeng.com/blog/2011/09/restful.html

2.[阮一峰.RESTful API 设计指南]: http://www.ruanyifeng.com/blog/2014/05/restful_api.html

3.[菜鸟教程.RESTful 架构详解]: http://www.runoob.com/w3cnote/restful-architecture.html


## 1. 基础概念

### 1.1. 起源

名称:REST(Representational State Transfer)

译名:表现层状态转化

提出人:Roy Thomas Fielding, 2000



#### 1.1.1. 表现层(Representation)

"资源(Resource)"是一种信息实体,它可以有多种外在表现形式。我们把"资源"具体呈现出来的形式，叫做它的"表现层"(Representation).

URI应该只代表"资源"的位置.它的具体表现形式,应该在HTTP请求的头信息中用Accept和Content-Type字段指定,这两个字段才是对"表现层"的描述.

#### 1.1.2. 状态转化(State Transfer)

这一部分参考菜鸟教程会更清晰

HTTP协议是一种无状态协议(Stateless Protocol),所有状态都保存在服务器端.因此,客户端想要操作服务器,必须通过某种手段,让服务器发生"状态转化",这种手段就是HTTP方法:GET/POST/PUT/DELETE



编者概述:

将网站的信息实体和服务看成**资源(Resource)**(名词),对这些资源的交互通过**HTTP方法(HTTP METHOD)**(动词)来体现



### 1.2. 核心概念

#### 1.2.1. 资源(Resource)

即**网络上的一个实体,或者说是网络上的一个具体信息**.可以是一段文本,一张图片甚至是一种服务.



#### 1.2.2. 唯一标识(URI, Uniform Resource Identifier)

"资源"在网络上的唯一标识(事实上同一个资源的标识并不一定是惟一的),在RESTful API中也是**资源的访问地址**



#### 1.2.3. 动词(HTTP METHOD)

URI



## 2. 设计指南



## 3. 开发实战

