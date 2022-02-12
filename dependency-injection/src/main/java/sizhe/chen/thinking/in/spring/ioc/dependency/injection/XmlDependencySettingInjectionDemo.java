package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于xml资源的依赖注入
 */
public class XmlDependencySettingInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
        //加载xml资源，解析生成spring beandefinition
        reader.loadBeanDefinitions(xmlResourcePath);
        //依赖查找并创建bean
        System.out.println(beanFactory.getBean("holder"));

    }
}
