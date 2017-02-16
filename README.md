# GintongGameSpider

需安装：1.8jdk环境，inter idea，sourcetree
1、安装1.8版本jdk，并且配置环境变量。
http://jingyan.baidu.com/article/f96699bb8b38e0894e3c1bef.html

2、安装sourcetree工具，注册git账号，并克隆代码库。 
下载地址：http://download.csdn.net/download/micro_hz/9419272
账号是git账号要区分开
注册地址：https://github.com/
Git代码仓库地址:https://github.com/pumpkin-/GintongGameSpider.git

3、安装idea开发工具，并且导入项目代码。
Idea下载地址：http://www.9553.com/soft/53689.htm
项目代码导入：可在File中的open中直接打开项目目录，也可新建一个项目，将项目代码复制到src目录下，idea会自动将代码同步。

4、在idea的File下project structure中的libraries下导入jar包。
    代码编写规范
    1、代码每天需上传至代码库中，与代码库保持一致、
    2、代码命名需遵循驼峰命名原则。
    3、抓取代码放在GintonggameSpider下，一个源一个包，包名以Spider开头，后跟源名。
    4、代码编写应尽量降低耦合度，能抽象的方法进行抽象出来。 
    简单实例：http://blog.csdn.net/lfsf802/article/details/7277013

5、代码内需标明注释，尽量捕捉能够捕捉的异常，保持代码的稳定性。 
Try{
System.out.println(“helloworld”);
}catch(Exception e){
System.out.println(“处理异常”);
}

数据规范
1、数据入正式库前，需先入测试库中，待数据库管理员确认无误，方可入正式库。 
数据库ip：122.59.74.132 账户：gtcom  密码：admin@gt.com1  测试库为：game_db_qa库  正式库为：game_db库
2、数据清洗需按规范进行，具体清洗格式根据相应需求决定。

服务器使用   
1、需部署到服务器上的增量抓取代码，应打成jar包，上传至相应jar目录下，如有额外添加的依赖包，也应一同上传至相应jar包目录下。

2、如有额外添加的新依赖包，需在/etc/profile中修改环境变量。

3、编写执行脚本时，需声明java环境变量，同时将执行所输出内容，重定向至相应目录下的log文件中。

4、编写crontab定时执行计划时，如产品等网站，定时间隔较长，知识等网站，对实时性需求较高的，则间隔时间较短。
