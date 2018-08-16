# RESTful 

## 0. 参考资料(Reference)

1.[阮一峰.理解 RESTful 架构]: http://www.ruanyifeng.com/blog/2011/09/restful.html

2.[阮一峰.RESTful API 设计指南]: http://www.ruanyifeng.com/blog/2014/05/restful_api.html

3.[菜鸟教程.RESTful 架构详解]: http://www.runoob.com/w3cnote/restful-architecture.html

4.[moonz-wu.译.好 RESTful API 的设计原则]: http://www.cnblogs.com/moonz-wu/p/4211626.html

5.[JeffreyLi.RESTful Service API 设计最佳工程实践和常见问题解决方案]: https://www.jianshu.com/p/cf80d644727e

6.[周梦南.深入理解 RESTful Api 架构]: https://mengkang.net/620.html




## 1. 基础知识(Basic)

### 1.1. 起源(History)

名称:**REST(Representational State Transfer)**

译名:表现层状态转化

提出人:Roy Thomas Fielding, 2000年的博士论文



### 1.2. 定义(Definitions)

#### 1.2.1. 核心定义

##### 1.2.1.1. 资源(Resource)

即**网络上的一个实体,或者说是网络上的一个具体信息**.可以是一段文本,一张图片,或者是一种服务;可以是数据库的一张表一条记录,也可以是抽象的概念.

##### 1.2.1.2. 集合(Collection)

某类资源的聚合体.

##### 1.2.1.3. 终端(EndPoint)

该 API 在 RESTful API 中的**资源的访问地址**,可简单理解为URL,代表某个具体的资源,或者资源的集合.

##### 1.2.1.4. 动词(Verbs)

RESTful API 使用 **HTTP 请求方式(HTTP Method)**来表示对资源的操作,常见的有如下:

| HTTP方法 | 含义         | 是否幂等 | 描述                                         |
| -------- | ------------ | -------- | -------------------------------------------- |
| GET      | 获取(SELECT) | 否       | 从服务器获取资源或集合                       |
| POST     | 创建(CREATE) | 是       | 从服务器新建一个资源                         |
| PUT      | 更新(UPDATE) | 否       | 在服务器更新资源(客户端提供更改后的完整资源) |
| PATCH    | 更新(UPDATE) | 否       | 在服务器更新资源(客户端提供资源更改的属性)   |
| DELETE   | 删除(DELETE) | 否       | 从服务器删除资源                             |



#### 1.2.2. 其他补充

##### 1.2.2.1. 幂等(Idempotent)

无边际效应，多次操作(即多次调用同一接口)得到相同的结果.

##### 1.2.2.2. URL段(URL Segment)

在URL里以斜杠分割的内容



## 2. 概念

### 2.1. 概述

在对以上的基础定义有一定认知后,我先说一下 RESTful API 的一些结论,再慢慢解释:

1. URL 段只能为名词(资源或集合);
2. EndPoint 代表了该资源或集合在服务器的访问地址;
3. 基于(1),对资源或集合的操作只能通过动词(HTTP Method)来实现;



### 2.2. 表现层(Representation)

资源可以有多种表示形式,资源最终呈现给客户端的形式,即为表现层.

```yaml
# 举例
图片在服务器段以二进制格式保存,展现到前端时可以是jpg,png甚至是txt
```

Endpoint只代表资源或集合的实体及其所在的位置,它的具体表现形式,应该是 HTTP 请求头中用 **Accept** 和 **Content-Type** 字段指定



### 2.3. 状态转化(State Transfer)

互联网通信协议HTTP协议,是一个无状态协议(Stateless Protocol),这意味着请求本身不携带任何状态.

#### 2.3.1. 应用状态与资源状态

状态应该区分应用状态和资源状态,客户端负责维护应用状态,而服务端维护资源状态.

##### 2.3.1.1. 资源状态的转移

客户端想要操作服务器的资源状态,必须通过某种手段,而这种手段在 RESTful API 中指的就是上面提到的表示操作方式的动词 **HTTP Method**.

#####2.3.1.2. 应用状态的转移

客户端应用状态在服务端提供的超媒体的指引下发生变迁.服务端通过超媒体告诉客户端当前状态有哪些后续状态可以进入.



## 3. 设计指南

### 3.1. 协议

### 3.2. 域名

### 3.3. 版本化(Versioning)

### 3.4. 接口设计

#### 3.4.1. 使用复数表示collection,加id表示resource

```yaml
# 举例
POST /statistics 创建一个统计
GET /statistics 获取统计列表
GET /statistics/1 获取指定统计
PUT /statistics/1 更新指定统计(完整资源)
PATCH /statistics/1 更新指定统计(部分更新)
DELETE /statistics/1 删除指定统计
```

#### 3.4.2. 表示资源的层级关系

```yaml
# 举例
GET /statistics/1/data 获取id=1的统计下的所有数据列表
```

*当子资源可以独立父资源存在时,则也可以通过 **/data** 进行资源操作



### 3.5. 过滤(Filtering)

#### 3.5.1. 筛选(Data Filter)

```yaml
# 举例
GET /statistics?userId=1&createTime=today 返回指定条件的数据(用户id为1,今天创建)
```

#### 3.5.2. 分页(Paging)

```yaml
# 举例
GET /statistics?page=1&size=20 返回第一页的20条数据
```

#### 3.5.3. 排序(Sorting)

```yaml
# 举例
GET /statistics?order=+userId,-title,-createTime 按照指定排序顺序排序(userId升序,title降序,createTime降序)
```
#### 3.5.4. 字段选择(Field Selection)

```yaml
# 举例
GET /statistics?fields=userId,title,fields 返回指定字段(userId,title,fields)
GET /statistics?fields=-userId,-statisticId 排除指定字段(userId,statisticId)
```

1.对dto字段进行过滤?

2.动态修改sql?(匹配实体)

#### 3.5.5. 扩展

```yaml
# 举例
GET /statistics?expand=userId 扩展指定字段信息(userId)
```



### 3.6. 状态码(Status Code)

### 3.7. 使用HATEOAS

**H**ypermedia **a**s **t**he **E**ngine **o**f **A**pplication **S**tate 超媒体作为应用状态的引擎,使客户端可以更方便进行下一步操作

### 3.8. 认证(Authentication)

### 3.9. 文档(Documentation)

## 3. 开发实战

1.[smallnest.最好的8个 Java RESTful 框架]: http://colobu.com/2015/11/15/best-available-java-restful-micro-frameworks/

2.[smallnest.Java RESTful框架的性能比较]: http://colobu.com/2015/11/17/Jax-RS-Performance-Comparison/