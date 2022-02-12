package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

import javax.annotation.Resource;
import javax.inject.Inject;


/**
 * {@link Aware}接口回调的Setter注入方法
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {
    private BeanFactory beanFactory;
    private ApplicationContext context;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AwareInterfaceDependencyInjectionDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection.xml");
        context.refresh();
        System.out.println("BeanFactoryAware <-> context :" + (context.getBean(AwareInterfaceDependencyInjectionDemo.class).beanFactory == context));
        System.out.println("BeanFactoryAware <-> context.getBeanFactory  :" + (context.getBean(AwareInterfaceDependencyInjectionDemo.class).beanFactory == context.getBeanFactory()));
        System.out.println("ApplicationContextAware <-> context :" + (context.getBean(AwareInterfaceDependencyInjectionDemo.class).context == context));
        System.out.println("ApplicationContextAware <-> context.getBeanFactory :" + (context.getBean(AwareInterfaceDependencyInjectionDemo.class).context == context.getBeanFactory()));
        context.close();


    }

    @Bean
    private UserHolder injectUserHolder(User user) {
        return new UserHolder(user);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
