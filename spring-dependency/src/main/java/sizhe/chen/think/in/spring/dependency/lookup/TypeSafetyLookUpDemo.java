package sizhe.chen.think.in.spring.dependency.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import sizhe.chen.think.in.spring.dependency.domain.User;

/**
 * 类型安全的依赖查找示例
 */
@Configuration
public class TypeSafetyLookUpDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TypeSafetyLookUpDemo.class);
        context.refresh();
        displayBeanFactoryGetBean(context);
        displayObjectFactoryGetBean(context);
        displayObjectFactoryIfAvailble(context);
        displayListableBeanFactory(context);
        displayObjectFactoryStreamOps(context);
        context.close();
    }

    private static void displayObjectFactoryStreamOps(AnnotationConfigApplicationContext context) {
        printBeansException("displayObjectFactoryStreamOps",()-> context.getBeanProvider(User.class).stream().forEach((User user)-> System.err.println(user)));
    }

    private static void displayListableBeanFactory(ListableBeanFactory beanFactory) {

        printBeansException("displayListableBeanFactory",()-> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectFactoryIfAvailble(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> userObjectProvider = context.getBeanProvider(User.class);
        System.err.println("userObjectProvider:" +userObjectProvider);
        printBeansException("displayObjectFactoryGetBean",() -> userObjectProvider.getIfAvailable())   ;
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printBeansException("displayBeanFactoryGetBean",()->beanFactory.getBean(User.class));
    }

    public static void displayObjectFactoryGetBean(AnnotationConfigApplicationContext context){
        ObjectProvider<User> userObjectProvider = context.getBeanProvider(User.class);
        System.err.println("userObjectProvider:" +userObjectProvider);
        printBeansException("displayObjectFactoryGetBean",() -> userObjectProvider.getObject())   ;

    }

    public static void printBeansException(String message,Runnable runnable){
        System.err.println("source from:" + message);
        try {

            runnable.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
