package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sizhe.chen.think.in.spring.ioc.overview.dependency.repository.UserRepository;

public class AliasDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/AliasName.xml");
        System.out.println(context.getBean("alias-repository", UserRepository.class).getUserObjectFactory().getObject());
        context.close();
    }
}
