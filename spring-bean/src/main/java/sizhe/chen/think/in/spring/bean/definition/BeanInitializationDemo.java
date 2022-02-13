package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import sizhe.chen.think.in.spring.bean.factory.InitialTestUserFactory;
import sizhe.chen.think.in.spring.bean.factory.UserFactory;

/**
 * Bean 初始化demo
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(BeanInitializationDemo.class);
        context.refresh();
       // System.out.println(context.getBeanDefinitionNames());
        for(String beanName : context.getBeanDefinitionNames()){
            System.out.println(beanName);
        }
        System.out.println(context.getBeanProvider(UserFactory.class).getObject().create());
        System.out.println(context.getBean("userFactory",UserFactory.class).create());


        context.close();
    }
    @Bean(initMethod = "initUserFactory",destroyMethod = "destroyUserFactory")
    //@Lazy
    public UserFactory userFactory(){
        return new InitialTestUserFactory();
    }

}
