package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;
import sizhe.chen.thinking.in.spring.ioc.dependency.annotation.UserGroup;

import java.util.Collection;

public class QualifierAnnotationDependencyInjectDemo {

    @Autowired
    @Qualifier("user3") //指定名称或者ID 进行注入
    private User nameUser;



    //整体上下问存在4个User类型的bean ,user ，superUser 通过xml的凡事注入， 两个通过java注解的方式进行注入s
    @Autowired
    private Collection<User>   allUsers;

    @Autowired
    @Qualifier
    private Collection<User>   qualifierUsers;

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

    @Autowired
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
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierAnnotationDependencyInjectDemo.class);
//        String classpath = "classpath:/META-INF/dependency-setter-injection.xml";
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
//        reader.loadBeanDefinitions(classpath);
        context.refresh();
QualifierAnnotationDependencyInjectDemo qualifierAnnotationDependencyInjectDemo = context.getBean(QualifierAnnotationDependencyInjectDemo.class);
        System.out.println("All Qulifier:"   + qualifierAnnotationDependencyInjectDemo.allUsers );
        System.out.println("Qulifier users:"   + qualifierAnnotationDependencyInjectDemo.qualifierUsers);
        System.out.println("Qulifier nameUser:"   + qualifierAnnotationDependencyInjectDemo.nameUser);
        System.out.println("UserGroup:"   + qualifierAnnotationDependencyInjectDemo.userGroups);



        context.close();
    }
}
