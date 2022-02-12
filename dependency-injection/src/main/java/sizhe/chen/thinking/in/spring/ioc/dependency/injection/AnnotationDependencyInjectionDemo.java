package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * 基于注解资源的依赖注入
 */
public class AnnotationDependencyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
        //加载xml资源，解析生成spring beandefinition
        reader.loadBeanDefinitions(xmlResourcePath);

        context.register(AnnotationDependencyInjectionDemo.class);
        context.refresh();
        System.out.println(context.getBean("userHolder"));
        context.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }


}
