package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

import javax.annotation.Resource;
import javax.inject.Inject;


/**
 * 基于java注解的依赖字段注入示例
 */
public class AnnotationDependencyFieldInjectionDemo {


    //@Autowired 会忽略静态字段。忽略这件事是在AutowiredAnnotationBeanPostProcessor 中做的
    //@Aurowired 会按照类型注入 当有多个相同类型的Bean的时候
    //通过@Qualifier 可以按照 名称注入，但是@Qualifier对@Resource 不可用，实际上是按照@Resource中的name 属性的值进行查找的。

    @Autowired
    @Qualifier("injectUserHolder")
    private UserHolder userHolder;

    @Resource(name ="injectUserHolder2")
    @Qualifier("injectUserHolder")
    private UserHolder userHolder2;

    @Inject
    @Qualifier("injectUserHolder2")
    private UserHolder userHolder3;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyFieldInjectionDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection.xml");
        context.refresh();

        System.out.println(context.getBean(AnnotationDependencyFieldInjectionDemo.class).userHolder);
        System.out.println(context.getBean(AnnotationDependencyFieldInjectionDemo.class).userHolder2);
        System.out.println(context.getBean(AnnotationDependencyFieldInjectionDemo.class).userHolder3);

    }

    @Bean
    private UserHolder injectUserHolder(User user) {
        return new UserHolder(user);
    }
    @Bean
    private UserHolder injectUserHolder2() {
        return new UserHolder(User.createUser());
    }
}
