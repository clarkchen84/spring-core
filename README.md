# spring-core

####  基础类型注入
- 原生类型： boolean,int,long,byte,char,double,float,short
- 标量类型： Number,Character ,Boolean,Enum,Local,Charset,Currency,Property,UUID
- 常规类型：Object,String,TimeZone,Calendar,Optional等
- spring 类型： Resource，InputSource，Formatter等

#### 集合类型xml注入

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util https://www.springframework.org/schema/util/spring-util.xsd">

    <bean id="user" class="sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User">
        <property name="id" value="1"/>
        <property name="name" value="张三"/>
        <property name="age" value="20"/>
        <property name="city" value="HANGZHOU"/>
        <property name="workCities">
            <util:list>
                <value>HANGZHOU</value>
                <value>BEIJING</value>
            </util:list>
        </property>
        <property name="lifeCities" value="BEIJING,SHANGHAI">
        </property>
        <property name="configLocation" value="classpath:/META-INF/user-config.properties"/>
    </bean>
    <bean id="superUser" class="sizhe.chen.think.in.spring.ioc.overview.dependency.domain.SuperUser" parent="user" primary="true">
        <property name="address" value="大兴"/>
    </bean>
    <bean id="objectFactory" class="org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean">
        <property name="targetBeanName" value="user"/>
    </bean>

    <bean id="holder" class="sizhe.chen.thinking.in.spring.ioc.dependency.injection.UserHolder" >
        <property name="user" ref="superUser"/>
    </bean>

</beans>
```





# 使用maven

#### 现在源码的命令

mvn dependency:resolve -Dclassifier=source

# git 命令

#### 使用Git 切换切换远程 分支到head

``` git
git remote set-head $REMOTE_NAME $BRANCH
```

因此，例如，将远程头部切换`origin`到分支`develop`将是：

```
git remote set-head origin develop
```











