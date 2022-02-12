package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link ObjectProvider} 实现延迟注入
 */
public class LazyAnnotationDependencyInjectDemo {

    @Autowired
    private User user;
    @Autowired
    private ObjectProvider<User> userObjectProvider;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LazyAnnotationDependencyInjectDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection.xml");
        context.refresh();
        LazyAnnotationDependencyInjectDemo dependencyInjectDemo = context.getBean(LazyAnnotationDependencyInjectDemo.class);
        dependencyInjectDemo.userObjectProvider.stream().forEach(user -> System.out.println(user));
        System.out.println(dependencyInjectDemo.user);
        context.close();
    }
}
