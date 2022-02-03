package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sizhe.chen.think.in.spring.bean.factory.InitialTestUserFactory;
import sizhe.chen.think.in.spring.bean.factory.UserFactory;

/**
 * bean 的垃圾回收（GC）
 */
@Configuration
public class BeanGarbageCollection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanGarbageCollection.class);
        context.refresh();
        context.getBean("userFactory");


        context.close();
        System.out.println("Spring 上下文已经关闭");
        //强制触发GC
        System.gc();



    }

    @Bean
    public UserFactory userFactory(){
        return new  InitialTestUserFactory();
    }
}
