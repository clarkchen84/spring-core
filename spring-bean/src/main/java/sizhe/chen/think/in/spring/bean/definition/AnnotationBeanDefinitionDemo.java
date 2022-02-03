package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

import java.lang.reflect.AnnotatedType;

/**
 * 注解的BeanDefinition 实例
 * {@link org.springframework.context.annotation.AnnotationConfigApplicationContext}
 */
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
               // = new AnnotationConfigApplicationContext(ConfigurationClass.class);
                  =new AnnotationConfigApplicationContext();
        //1 . 通过@Bean的方式定义
        //使用构造器的方式传入配置类，就一定不能使用refresh，会抛出 GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once
        annotationConfigApplicationContext.register(ConfigurationClass.class);
        registerBeanDefinition(annotationConfigApplicationContext,null,User.class);
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBeansOfType(User.class));
        //2.通过@Component的方式
        //3.通过Import的方式进行导入

        annotationConfigApplicationContext.close();
    }

    public static void registerBeanDefinition(
            BeanDefinitionRegistry beanDefinitionRegistry, String name,Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass)
                .addPropertyValue("id",1L).addPropertyValue("name","lisi")
                .addPropertyValue("age",24);
        if(StringUtils.hasText(name)) {
            beanDefinitionRegistry.registerBeanDefinition(name, beanDefinitionBuilder.getBeanDefinition());
        }else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),beanDefinitionRegistry);
        }


    }


    @Configuration
    public static class ConfigurationClass{

        @Bean(name={"user","zhangsan"})
        public User user(){
            User user = new User();
            user.setAge(30);
            user.setName("张三");
            user.setId(1L);
            return user;
        }

    }
}
