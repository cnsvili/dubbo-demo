# dubbo-demo

## 1.先安装zookeeper和java运行环境(1.7+)

## 2.hello-api

+ mvn clean install

## 3.hello-provider 

+ mvn package

+ 将lib目录和hello-provider.jar拷贝到指定的目录下

+ java -jar hello-provider.jar


## 注意事项

### 外网ip

zookeeper服务的注册和解析默认为内网ip,如需绑定外网ip,请参见官方指南
http://dubbo.apache.org/books/dubbo-user-book/demos/hostname-binding.html

e.g.

provider

```xml
<dubbo:registry client="zkclient" address="zookeeper://xxx.xxx.xxx.xxx:2181"/>
<dubbo:protocol name="dubbo" port="20880"/>
```

consumer

```xml
<dubbo:registry client="zkclient" address="zookeeper://xxx.xxx.xxx.xxx:2181"/>
<dubbo:protocol name="dubbo" port="20881"/>
```
### dubbo cache

dubbo会默认会在本地缓存注册中心的信息文件，默认路径在//home/[user]/.dubbo/dubbo-registry-xxx.xxx.xxx.xxx.cache

一个服务有多个应用有用到dubbo的时候更新注册中心的本地缓存，在更新本地缓存冲突时，就有问题;

linux下非root用户执行tomcat,无权限创建文件;

解决方案,在consumer端指定文件目录

e.g.

consumer

```xml
<dubbo:registry client="zkclient" address="zookeeper://xxx.xxx.xxx.xxx:2181" file="/opt/tomcat/dubbo/hello-consumer.cache"/>
<dubbo:protocol name="dubbo" port="20881"/>
```

