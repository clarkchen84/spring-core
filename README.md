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

#### 限定注入

* 限定注入的作用 `@Qualifier`
  * 开始用名称进行限定

    ``` java
    @Autowired
    @Qualifier("user") //指定名称或者ID 进行注入
    private User nameUser;
    ```
    
  * 用来对bean 进行分组
  
    * **我觉得这里面allUser没有注入4个bean的原因是通过这个方式自动注入， 只注入成功了通过xml的方式注入的javabean**
    
      ***当我完全使用Annotation 的方式注入java bean的场合。 allUser中注入的是4个bean***
    
    ```java
     //整体上下问存在4个User类型的bean ,user ，superUser 通过xml的凡事注入， 两个通过java注解的方式进行注入
    @Autowired
    private Collection<User>   allUsers;// allUser注入的是没有使用@Qualifer 注入的两个通过XML注入的bean
    
    @Autowired
    @Qualifier
    private Collection<User>   qualifierUsers; //qualifierUsers 注入的是通过@Qualifer注入的两个
    																					//使用java注解的方式注入的bean
    @Bean
    @Qualifier// 进行逻辑分组
    public User user1(){
      return User.createUser();
    }
    
    @Bean
    @Qualifier// 进行逻辑分组
    public User user2(){
      User user  =  User.createUser();
    
      user.setName("wangxiaowu");
      return user;
    }
    ```
  
* 基于`@Qualifier`的扩展

  * SpringCloud的注解 @LoadBalance
  
  ``` java
   @UserGroup
      private Collection<User>   userGroups;
      @Bean
      @UserGroup
      public User user3(){
          User user  =  User.createUser();
  
          user.setName("yanxiaoqi");
          return user;
      }
      @Bean
      @UserGroup
      public User user4(){
          User user  =  User.createUser();
  
          user.setName("小七");
          return user;
      }
  
  @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Inherited
  @Documented
  @Qualifier
  public @interface UserGroup {
  }
  
  ```

 #### 延迟注入
 * 通过@Autowired 标注 ObjectProvider<对象类型> 可以进行延迟加载
 * 使用ObjectFactory同样也能进行延迟加载
 * 使用ObjectProvider比较好，应为ObjectProvider 是类型安全的
 ``` java
  @Autowired
    private User user;
    @Autowired
    private ObjectProvider<User> userObjectProvider;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LazyAnnotationDependencyInjectDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection.xml");
        context.refresh();
        LazyAnnotationDependencyInjectDemo dependencyInjectDemo = context.getBean(LazyAnnotationDependencyInjectDemo.class);
        dependencyInjectDemo.userObjectProvider.stream().forEach(user -> System.out.println(user));
        System.out.println(dependencyInjectDemo.user);
        context.close();
    }
  ```
  #### 依赖处理的过程
  1. 入口 `DefaultListableBeanFactory#resolveDependency`
  2. 依赖描描述符`DependencyDescriptor`
  3. 自动绑定候选对象处理器 `AutowireCandidateResolver`

​    



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











