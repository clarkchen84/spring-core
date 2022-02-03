package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        System.out.println(context.getBean("userFactory",UserFactory.class).create());

        context.close();
    }
    @Bean(initMethod = "initUserFactory",destroyMethod = "destroyUserFactory")
    public UserFactory userFactory(){
        return new InitialTestUserFactory();
    }

}
