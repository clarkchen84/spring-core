package sizhe.chen.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过{@link ObjectProvider}进行依赖查找
 */
@Configuration
public class ObjectProviderDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectProviderDemo.class);


        context.refresh();
        lookUpByProvider(context);
        context.close();

    }

    private static void lookUpByProvider(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> hello=  context.getBeanProvider(String.class);
        System.out.println(hello.getObject());

    }

    @Bean
    public String helloWorld(){
        return  "hello, world";
    }


}
