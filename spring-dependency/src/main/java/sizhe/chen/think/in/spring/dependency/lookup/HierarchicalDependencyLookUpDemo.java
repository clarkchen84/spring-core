package sizhe.chen.think.in.spring.dependency.lookup;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找
 * {@link HierarchicalBeanFactory}
 */
public class HierarchicalDependencyLookUpDemo {
    public static void main(String[] args) {
        //1. 获取HierarchicalBeanFactory<-ConfigurableBeanFactory<-ConfigurableListableBeanFactory
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        context.register(HierarchicalDependencyLookUpDemo.class);
        System.out.println("当前BeanFactory的父BeanFactory:" + beanFactory.getParentBeanFactory());
        DefaultListableBeanFactory listableBeanFactory =
                new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader =new XmlBeanDefinitionReader(listableBeanFactory);
        String location = "classpath:/META-INF/bean-creation.xml";
        reader.loadBeanDefinitions(location);
        beanFactory.setParentBeanFactory(listableBeanFactory);



        context.refresh();

     //   System.out.println("父Context的自bean：" + beanFactory.getBean("user-by-static-method"));

        displayContainsLocalBean(beanFactory,"user-by-static-method");
        displayContainsLocalBean(listableBeanFactory,"user-by-static-method");
        displayContainsBean(beanFactory,"user-by-static-method");
        displayContainsBean(listableBeanFactory,"user-by-static-method");
        context.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory factory,String name){
        System.out.printf("当前BeanFactory【%s】是否包含bean 【name %s】: %s\n"
                ,factory,name,containsBean(factory,name));
    }

    public static boolean containsBean(HierarchicalBeanFactory hierarchicalBeanFactory,String name){
        if(hierarchicalBeanFactory.containsLocalBean(name)){
            return true;
        }

        BeanFactory  beanFactory = hierarchicalBeanFactory.getParentBeanFactory();
        if(beanFactory == null){
            return false;
        }

        if(beanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(beanFactory);
            if(parentHierarchicalBeanFactory.containsLocalBean(name)){
                return true;
            }else{
                return  containsBean(parentHierarchicalBeanFactory,name);
            }
        }
        return  beanFactory.containsBean(name);

    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String name){
        System.out.printf("当前BeanFactory【%s】是否包含bean 【name %s】: %s\n"
                ,beanFactory,name,beanFactory.containsLocalBean(name));
    }
}
