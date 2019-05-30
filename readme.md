## 效果展示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190530140016156.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM0ODQ1Mzk0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190530140053726.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM0ODQ1Mzk0,size_16,color_FFFFFF,t_70)
## 项目简介

为方便开发者查看线上服务器日志，做的一个简单的日志管理系统。

## 项目结构

本项目为maven聚合多模块项目。

### log2mongo

根模块，这个模块又继承于 [yuanwl-framework](https://github.com/MRLEILOVE/framework-parent.git)（个人项目简单框架），可以方便地使用该模块的各种通用模块和依赖。

- log2mongo-server：日志管理系统，读取MongoDB记录的日志，以友好的方式呈现给开发者；
- log4j2-demo：使用log4j2记录日志的demo，在这里面可以把日志写到MongoDB；

## 项目使用

1. 参考 log4j2-demo 给你的项目使用上 log4j2 ；

2. maven 打包 log2mongo-server 成可执行jar包，然后部署到线上服务器运行，linux下命令参考：nohup /dodou/jdk8/bin/java -jar /dodou/log2mongo-server-1.0.0-SNAPSHOT.jar &；

3. 在 nginx 里配置好子域名和反向代理到 log2mongo-server ，然后开发者便可以登录使用该日志系统了；
