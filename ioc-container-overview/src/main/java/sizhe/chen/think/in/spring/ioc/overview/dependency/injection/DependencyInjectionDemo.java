package sizhe.chen.think.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sizhe.chen.think.in.spring.ioc.overview.dependency.annotation.Super;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;
import sizhe.chen.think.in.spring.ioc.overview.dependency.repository.UserRepository;

/**
 * 依赖查找
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/DependencyInject.xml");
        System.out.println(context.getBean("userRepository"));
        UserRepository userRepository = (UserRepository) context.getBean("userRepository");

        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == context);
        System.out.println(userRepository.getUserObjectFactory().getObject());
        System.out.println(userRepository.getApplicationContextObjectFactory().getObject() );

        context.close();
    }

    private static void getBeanByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            System.out.println("by Annotation" + ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class));
        }
    }

    private static void getBeanByCollection(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            System.out.println("by collection" + ((ListableBeanFactory) beanFactory).getBeansOfType(User.class));
        }
    }

    private static void getBeanByType(BeanFactory beanFactory) {
        System.out.println("by type" + beanFactory.getBean(User.class));
    }

    public static void getBeanRealTime(BeanFactory beanFactory){
        System.out.println("RealTime:" + beanFactory.getBean("user"));

    }

    public static void getBeanLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = beanFactory.getBean("objectFactory",ObjectFactory.class);
        System.out.println("Lazy:"+objectFactory.getObject());

    }
}
