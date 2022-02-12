package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * 基于名称的自动注入
 */
public class AutoWiringByNameDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        //加载xml资源，解析生成spring beandefinition
        reader.loadBeanDefinitions(xmlResourcePath);
        //依赖查找并创建bean
        System.out.println(beanFactory.getBean("holder"));
    }



}
