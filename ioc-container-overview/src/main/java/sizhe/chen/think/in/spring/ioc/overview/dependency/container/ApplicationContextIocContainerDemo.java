package sizhe.chen.think.in.spring.ioc.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

public class ApplicationContextIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();
        System.out.println(context.getBean("user"));
        lookupBeanByType(context);
    }
    public static void lookupBeanByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
             ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            System.out.println(listableBeanFactory.getBeansOfType(User.class));
        }
    }

    @ImportResource("classpath:/META-INF/DependencyInject.xml")
    @Configuration
    public static class Config{

        @Bean
        public User user(){
            return new User();
        }

    }
}
