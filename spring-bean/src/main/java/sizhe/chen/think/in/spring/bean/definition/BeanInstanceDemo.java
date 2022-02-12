package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化 demo
 */
public class BeanInstanceDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation.xml");
        //使用静态方法注入
        System.out.println("使用静态方法实例bean" + beanFactory.getBean("user-by-static-method"));
        //使用工厂类注入
        System.out.println("使用工厂类注入" + beanFactory.getBean("user-by-factory-method"));
        //使用FacotryBean
        System.out.println("使用FactoryBean" + beanFactory.getBean("user-by-factory-bean"));
    }
}
