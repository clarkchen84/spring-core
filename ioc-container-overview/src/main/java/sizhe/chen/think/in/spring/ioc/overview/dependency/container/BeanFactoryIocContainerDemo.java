package sizhe.chen.think.in.spring.ioc.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

public class BeanFactoryIocContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        System.out.println(xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("/META-INF/DependencyInject.xml")));


        System.out.println(beanFactory.getBean("userRepository"));
        lookupBeanByType(beanFactory);
    }
    public static void lookupBeanByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
             ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            System.out.println(listableBeanFactory.getBeansOfType(User.class));
        }
    }
}
