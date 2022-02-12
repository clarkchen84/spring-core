package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * 基于API资源的依赖注入
 */
public class ApiDependencyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
        //加载xml资源，解析生成spring beandefinition
        reader.loadBeanDefinitions(xmlResourcePath);

        context.registerBeanDefinition("userHolder",createUserHolderBeanDefinition());
        context.refresh();
        System.out.println(context.getBean("userHolder"));
        context.close();
    }

//    @Bean
//    public UserHolder userHolder(User user){
//        return new UserHolder(user);
//    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user","superUser");
        return builder.getBeanDefinition();
    }


}
