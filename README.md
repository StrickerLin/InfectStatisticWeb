# InfectStatisticWeb
##  一、作业链接
[InfectStatisticWeb](https://edu.cnblogs.com/campus/fzu/2020SpringW/homework/10456)
## 二、结对学号
221701101 林露 博客地址：[https://www.cnblogs.com/lu28/](https://www.cnblogs.com/lu28/)
221701108 李波 博客地址：[https://www.cnblogs.com/Striker-Lin/](https://www.cnblogs.com/Striker-Lin/)

## 三、项目介绍
使用tomcat构建的疫情可视化的web程序

**功能**：
* 能够了解到全国有多少各类患者。
* 可以根据地图上的颜色深浅直观了解各个省份的感染情况.
* 将鼠标悬浮在省份的上方可以显示省份粗略的感染信息。
* 点击具体省份可以跳转到详情页面查看各省的防染详情。
* 通过折线图能够直观地了解，各地的感染趋势。

## 四、构建和运行
1、安装tomcat，下载sqlite-jdbc JAR文件

2、将本项目下载到%tomcatInstallDirectory%/webapp/ROOT/目录下

3、在tomcat目录下的lib文件夹里添加sqlite-jdbc JAR文件。

4、运行Main.java文件来获取数据，其中有一些爬取返回错误的提示（512错误等），请忽略。
等到控制台输出“数据初始化成功”字样。

5、到%tomcatInstallDirectory%/bin下启动startup.dat即可

6、打开浏览器，输入http://localhost:8080/InfectStatisticWeb/


