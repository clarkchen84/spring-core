package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sizhe.chen.think.in.spring.bean.factory.DefaultUserFactory;
import sizhe.chen.think.in.spring.bean.factory.UserFactory;
import sizhe.chen.think.in.spring.bean.factory.UserFactoryBean;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 使用ServiceLoader 加载,SPI的加载方式
 *
 * {@link  ServiceLoader}
 */
public class SpecificBeanLoaderDemo {
    public static void main(String[] args) throws Exception {
        //1. 使用Spring 提供ServiceFactoryBean 实现
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/specific-bean.xml");
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        System.out.println("使用SpringService loader" + beanFactory.getBean("userFactory"));
        //2. 使用Spring 提供{@link ServiceLoaderFactoryBean} 实现
       // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/specific-bean.xml");
        demoServiceLoader( beanFactory.getBean("userFactoryLoader",ServiceLoader.class));
        //3.通过AutoWiredCapableBeanFactory创建 ,UserFactory对象
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println("使用createBean创建 ：" + userFactory.create());

        //jdk 原生使用ServiceLoader
        demoServiceLoader();
       // BeanFactory beanFactory
    }

    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class,Thread.currentThread().getContextClassLoader());
        demoServiceLoader(serviceLoader);


    }
    public static void demoServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> userFactories = serviceLoader.iterator();
        while (userFactories.hasNext()){
            System.out.println(userFactories.next().create());
        }


    }
}
