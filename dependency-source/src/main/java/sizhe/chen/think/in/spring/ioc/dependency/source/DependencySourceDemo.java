package sizhe.chen.think.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 依赖来源示例
 */
public class DependencySourceDemo {

    @Autowired
    private BeanFactory beanFactory;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DependencySourceDemo.class);
        context.refresh();



        context.close();
    }
}
